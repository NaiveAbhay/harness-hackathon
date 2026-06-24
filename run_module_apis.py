#!/usr/bin/env python3
"""
run_module_apis.py
==================
Load a Harness module's *local* OpenAPI spec (the YAML files cloned in this
repo), then fire a live request at every operation in that module against a
sandbox and capture each response.

Why local spec: apidocs.harness.io/openapi.json returns HTML, not the spec.
Each module here ships its own `<module>/openapi.yaml`, so we read that.

Usage (defaults target pipeline-service on the bootcamp sandbox):

    python3 run_module_apis.py --module pipeline-service

Configuration precedence: CLI flag > environment variable > built-in default.
Secrets (api key) should come from env / pipeline secret, not the CLI.

Env vars:
    HARNESS_API_KEY     x-api-key PAT
    HARNESS_ACCOUNT_ID  account identifier
    HARNESS_BASE_URL    sandbox base url
    HARNESS_ORG         org identifier
    HARNESS_PROJECT     project identifier

Output:
    - A console summary (one line per call).
    - A JSON report (--output, default api_run_report.json) with full details.

Dependencies: PyYAML, jsonref  (pip install pyyaml jsonref)
HTTP uses the standard library (urllib) so it runs on a bare python image.
"""

import argparse
import json
import os
import secrets
import sys
import time
import urllib.request
import urllib.error
import urllib.parse

try:
    import yaml
    import jsonref
except ImportError:
    sys.exit("Missing deps. Run: pip install pyyaml jsonref")


# --------------------------------------------------------------------------- #
# Defaults (bootcamp sandbox). Override via flags or env vars.
# --------------------------------------------------------------------------- #
DEFAULTS = {
    "base_url": "https://bootcamp-playground.pr2.harness.io",
    "account": "fAp1ee68RWmCJrfsdhwMeA",
    "org": "bootcampjune2026",
    "project": "Wakanda",
    # SECURITY: never hardcode the PAT in committed code. Supply it at runtime via the
    # HARNESS_API_KEY env var (in CI it comes from a Harness Secret, masked in logs) or --api-key.
    "api_key": "",
}

METHOD_ORDER = {"get": 0, "post": 1, "put": 2, "patch": 3, "delete": 4}
HTTP_METHODS = set(METHOD_ORDER)

# --------------------------------------------------------------------------- #
# Write-operation safety policy
# --------------------------------------------------------------------------- #
# GET is always safe (read-only). For write methods we operate on an explicit
# ALLOWLIST only, and we *additionally* hard-block a denylist so that even an
# accidental `--methods post,put,delete` can never fire a destructive call.
#
# Bucket A (pure compute, persists nothing) + Bucket B (create a throwaway
# resource scoped to a dummy pipeline). Everything in here is non-destructive.
SAFE_WRITE_ALLOWLIST = {
    # Bucket A - compute only, no persistence
    "get-steps",            # POST /v1/step-pallete
    "get-inputs-schema",    # POST /v1/pipeline-schema/inputs-schema
    "merged-input-sets",    # POST /v1/orgs/{org}/projects/{project}/input-sets/merge
    # Bucket B - create a uniquely-named throwaway, scoped to the dummy pipeline
    "create-pipeline",      # POST /v1/orgs/{org}/projects/{project}/pipelines
    "create-input-set",     # POST .../input-sets?pipeline=<dummy>
}

# Bucket C - full edit/delete lifecycle, but ONLY ever against the throwaway
# dummy this run just created. Three independent guards make it impossible for
# any of these to touch a real/shared resource:
#   1. We force a CLEAN context (only the dummy ids are visible), so a harvested
#      real id can never leak into the target.
#   2. We only run a delete/update if THIS run actually created that dummy.
#   3. A hard pre-send assertion aborts the whole run if the resolved URL does
#      not point at the dummy, or if it contains any PROTECTED (real) id.
DUMMY_LIFECYCLE_ALLOWLIST = {
    "update-pipeline",      # PUT    .../pipelines/{pipeline}  (pipeline = dummy)
    "patch-pipeline",       # PATCH  .../pipelines/{pipeline}  (pipeline = dummy)
    "update-input-set",     # PUT    .../input-sets/{input-set}?pipeline=<dummy>
    "delete-input-set",     # DELETE .../input-sets/{input-set}?pipeline=<dummy>
    "delete-pipeline",      # DELETE .../pipelines/{pipeline}   (cleanup, runs last)
}

# Never fire these regardless of --methods / --safe-writes. These either launch
# real executions, act on live approvals, auto-fire via triggers, or rewrite git
# storage - none of which can be made safe by scoping to a dummy.
WRITE_HARD_DENY = {
    "update-pipeline-git-metadata", "update-input-set-git-metadata",
    "update-trigger", "create-trigger", "delete-trigger",
    "moveConfig", "inputSetsMoveConfig",
    "importPipelineFromGit", "importInputSetFromGit",
    "execute-pipeline", "runDynamicExecutionWithInputYaml",
    "rerun-pipeline", "rerun-stages-execution-of-pipeline",
    "retry-pipeline-with-inputset-pipeline-yaml", "execute-stages-with-input-yaml",
    "addHarnessApprovalActivityByPipelineExecutionId",
    "start-pipeline-validation-event",  # starts an async validation event
}

# Plain-English reason each denied op is excluded - surfaced verbatim in the
# coverage report so the dashboard can show *why* we don't call it.
HARD_DENY_REASON = {
    "execute-pipeline": "launches a real pipeline execution on shared infra",
    "runDynamicExecutionWithInputYaml": "launches a real pipeline execution",
    "rerun-pipeline": "re-runs a real execution",
    "rerun-stages-execution-of-pipeline": "re-runs real pipeline stages",
    "retry-pipeline-with-inputset-pipeline-yaml": "retries a real execution",
    "execute-stages-with-input-yaml": "launches a real stage execution",
    "addHarnessApprovalActivityByPipelineExecutionId": "acts on a live approval / execution",
    "start-pipeline-validation-event": "starts an async server-side validation event",
    "create-trigger": "a trigger can auto-fire real pipelines",
    "update-trigger": "mutates a real, possibly shared trigger",
    "delete-trigger": "removes a real, possibly shared trigger",
    "moveConfig": "rewires a pipeline's git storage",
    "inputSetsMoveConfig": "rewires an input-set's git storage",
    "importPipelineFromGit": "writes/imports from a git repo",
    "importInputSetFromGit": "writes/imports from a git repo",
    "update-pipeline-git-metadata": "mutates real git metadata",
    "update-input-set-git-metadata": "mutates real git metadata",
}


# --------------------------------------------------------------------------- #
# Spec loading
# --------------------------------------------------------------------------- #
def load_spec(spec_path):
    """Load YAML and fully resolve internal $ref pointers."""
    with open(spec_path, "r") as fh:
        raw = yaml.safe_load(fh)
    # proxies=False + lazy_load=False fully materialises $refs into real dicts.
    # (The old json.dumps(default=str) round-trip stringified unresolved proxies,
    # which silently dropped component-level $ref parameters like the required
    # 'pipeline' query param -> spurious 400s.)
    return jsonref.replace_refs(
        raw,
        base_uri="file://" + os.path.abspath(spec_path),
        proxies=False,
        lazy_load=False,
    )


# --------------------------------------------------------------------------- #
# Example value generation from a JSON schema
# --------------------------------------------------------------------------- #
def example_from_schema(schema, depth=0):
    """Best-effort example value for an OpenAPI/JSON schema fragment."""
    if not isinstance(schema, dict) or depth > 6:
        return "sample"

    # Explicit examples win.
    if "example" in schema:
        return schema["example"]
    if "default" in schema:
        return schema["default"]
    if "x-examples" in schema and isinstance(schema["x-examples"], dict):
        first = next(iter(schema["x-examples"].values()), None)
        if first is not None:
            return first
    if "enum" in schema and schema["enum"]:
        return schema["enum"][0]

    # Composed schemas.
    for key in ("allOf", "anyOf", "oneOf"):
        if key in schema and schema[key]:
            return example_from_schema(schema[key][0], depth + 1)

    t = schema.get("type")
    if t == "object" or "properties" in schema:
        obj = {}
        props = schema.get("properties", {}) or {}
        required = set(schema.get("required", []) or [])
        for name, sub in props.items():
            # Always include required props; include a few optional ones for shape.
            if name in required or len(obj) < 4:
                obj[name] = example_from_schema(sub, depth + 1)
        return obj
    if t == "array":
        item = example_from_schema(schema.get("items", {}), depth + 1)
        return [item]
    if t in ("integer", "number"):
        return 1
    if t == "boolean":
        return False
    # default: string
    return "sample"


# --------------------------------------------------------------------------- #
# Parameter / path resolution
# --------------------------------------------------------------------------- #
def build_context(cfg):
    """Map common path/query parameter names to concrete values."""
    return {
        "account": cfg["account"],
        "accountidentifier": cfg["account"],
        "harness-account": cfg["account"],
        "org": cfg["org"],
        "orgidentifier": cfg["org"],
        "org_identifier": cfg["org"],
        "project": cfg["project"],
        "projectidentifier": cfg["project"],
        "project_identifier": cfg["project"],
    }


def resolve_param_value(param, context, discovered):
    """Pick a value for a single parameter object."""
    name = (param.get("name") or "").strip()
    key = name.lower()
    schema = param.get("schema", {}) or {}

    # 1) discovered resource ids (e.g. a pipeline id grabbed from a list call)
    if key in discovered:
        return discovered[key]
    # 2) known context (account/org/project)
    if key in context:
        return context[key]
    # 3) schema-provided example/default/enum
    if any(k in schema for k in ("example", "default", "enum")) or "example" in param:
        return param.get("example", example_from_schema(schema))
    # 4) heuristic fallback for id-like path params
    return "sample"


def _norm(name):
    """Normalise a param/key name so 'pipeline_identifier', 'pipelineId',
    'pipelineRef' and 'pipeline' all collapse to the same token for matching."""
    s = "".join(ch for ch in (name or "").lower() if ch.isalnum())
    for suf in ("identifier", "ref", "id"):
        if s.endswith(suf) and len(s) > len(suf):
            s = s[: -len(suf)]
    return s


def lookup(name, *maps):
    """Resolve a value for `name` from any of the given dicts. Tries an exact
    lowercase match first, then a normalised (alias) match. Returns None if absent."""
    k = (name or "").lower()
    for m in maps:
        if k in m:
            return m[k]
    n = _norm(name)
    for m in maps:
        for mk, mv in m.items():
            if _norm(mk) == n:
                return mv
    return None


def load_seed(path):
    """Optional seed.json of known-real ids (pipeline, input-set, trigger, ...).
    Missing file is fine -> returns {}. Keys are lowercased."""
    if not path or not os.path.exists(path):
        return {}
    try:
        with open(path) as fh:
            data = json.load(fh)
        return {str(k).lower(): v for k, v in data.items() if not isinstance(v, (dict, list))}
    except (json.JSONDecodeError, OSError) as e:
        print(f"WARNING: could not read seed file {path}: {e}")
        return {}


def fill_path(path, parameters, context, discovered):
    """Substitute {placeholders} in a path template."""
    # Map declared path params by name for quick lookup.
    by_name = {(p.get("name") or "").lower(): p for p in parameters if p.get("in") == "path"}
    result = path
    for token in _placeholders(path):
        key = token.lower()
        # Prefer a real value from discovered ids / seed / context (with alias matching).
        val = lookup(token, discovered, context)
        if val is None:
            if key in by_name:
                val = resolve_param_value(by_name[key], context, discovered)
            else:
                val = "sample"
        result = result.replace("{" + token + "}", urllib.parse.quote(str(val), safe=""))
    return result


def _placeholders(path):
    out, buf, capture = [], "", False
    for ch in path:
        if ch == "{":
            capture, buf = True, ""
        elif ch == "}":
            capture = False
            out.append(buf)
        elif capture:
            buf += ch
    return out


def build_query(parameters, context, discovered, include_optional):
    """Build the query string dict from parameter definitions."""
    q = {}
    for p in parameters:
        if p.get("in") != "query":
            continue
        required = bool(p.get("required"))
        schema = p.get("schema", {}) or {}
        has_example = any(k in schema for k in ("example", "default", "enum")) or "example" in p
        name = p.get("name")
        # Real value from seed/discovered/context (alias-aware) wins; it turns many
        # spurious 400s (missing required query param) into genuine calls.
        real = lookup(name, discovered, context)
        if real is not None:
            q[name] = real
        elif required:
            q[name] = resolve_param_value(p, context, discovered)
        elif include_optional and has_example:
            q[name] = resolve_param_value(p, context, discovered)
    return q


def build_headers(operation, parameters, cfg, context):
    """Assemble request headers (auth + declared header params)."""
    headers = {
        "x-api-key": cfg["api_key"],
        "Harness-Account": cfg["account"],
        "Accept": "application/json",
    }
    for p in parameters:
        if p.get("in") != "header":
            continue
        name = p.get("name")
        if name and name.lower() in context:
            headers[name] = str(context[name.lower()])
    return headers


# --------------------------------------------------------------------------- #
# Discovery: pull ids out of list responses so dependent calls have real values
# --------------------------------------------------------------------------- #
ID_KEYS = ("identifier", "id", "slug", "uuid", "name")


def harvest_ids(path, body):
    """
    From a successful GET response, guess the resource name from the last
    static path segment and record an id we can reuse for {placeholder} calls.
    e.g. GET /.../pipelines -> {'pipeline': <first item's identifier>}
    """
    found = {}
    items = None
    if isinstance(body, list):
        items = body
    elif isinstance(body, dict):
        for v in body.values():
            if isinstance(v, list) and v and isinstance(v[0], dict):
                items = v
                break
    if not items or not isinstance(items[0], dict):
        return found
    first = items[0]
    ident = next((first[k] for k in ID_KEYS if k in first and isinstance(first[k], (str, int))), None)
    if ident is None:
        return found
    # Derive singular resource name from the last non-placeholder path segment.
    segs = [s for s in path.split("/") if s and not s.startswith("{")]
    if segs:
        resource = segs[-1].rstrip("s")  # pipelines -> pipeline
        found[resource.lower()] = ident
        found[segs[-1].lower()] = ident
    return found


# --------------------------------------------------------------------------- #
# HTTP
# --------------------------------------------------------------------------- #
def send(method, url, headers, body, timeout):
    data = None
    headers = dict(headers)
    if body is not None:
        data = json.dumps(body).encode()
        headers["Content-Type"] = "application/json"
    req = urllib.request.Request(url, data=data, method=method.upper(), headers=headers)
    started = time.time()
    try:
        with urllib.request.urlopen(req, timeout=timeout) as resp:
            text = resp.read().decode("utf-8", "replace")
            return resp.status, dict(resp.headers), text, time.time() - started
    except urllib.error.HTTPError as e:
        text = e.read().decode("utf-8", "replace")
        return e.code, dict(e.headers), text, time.time() - started
    except Exception as e:  # noqa: BLE001 - report any transport error
        return None, {}, f"{type(e).__name__}: {e}", time.time() - started


def parse_json(text):
    try:
        return json.loads(text)
    except Exception:  # noqa: BLE001
        return None


# --------------------------------------------------------------------------- #
# Main
# --------------------------------------------------------------------------- #
def collect_operations(spec, methods_filter, safe_writes=False):
    """Flatten spec.paths into a sorted list of operations to call.

    Safety gate:
      * GET is always allowed.
      * Any operationId in WRITE_HARD_DENY is dropped, always (even if the
        method was requested) - execute/trigger/git ops can never slip through.
      * Other write methods (post/put/patch/delete) are included only when
        --safe-writes is on AND the operationId is in SAFE_WRITE_ALLOWLIST or
        DUMMY_LIFECYCLE_ALLOWLIST (the latter act only on the throwaway dummy).
    """
    allowed_writes = SAFE_WRITE_ALLOWLIST | DUMMY_LIFECYCLE_ALLOWLIST
    ops = []
    for path, item in (spec.get("paths") or {}).items():
        shared = item.get("parameters", []) or []
        for method, op in item.items():
            if method not in HTTP_METHODS or method not in methods_filter:
                continue
            op_id = (op or {}).get("operationId")
            if method != "get":
                # Hard block execute/trigger/git ops outright.
                if op_id in WRITE_HARD_DENY:
                    continue
                # Writes only run in safe-writes mode and only if allowlisted.
                if not (safe_writes and op_id in allowed_writes):
                    continue
            params = [p for p in (shared + (op.get("parameters", []) or [])) if isinstance(p, dict)]
            ops.append({"path": path, "method": method, "op": op, "params": params})
    ops.sort(key=lambda o: (METHOD_ORDER[o["method"]], o["path"]))
    return ops


def build_coverage(spec, safe_writes):
    """Classify EVERY operation in the spec by how we treat it, so the dashboard
    can show - transparently - exactly what we called, what we only static-check,
    and what we deliberately skip and why. This is the trust backbone."""
    cov = []
    for path, item in (spec.get("paths") or {}).items():
        for method, op in item.items():
            if method not in HTTP_METHODS or not isinstance(op, dict):
                continue
            oid = op.get("operationId")
            if method == "get":
                disp, reason = "live_get", "read-only GET - always safe to call live"
            elif oid in {"get-steps", "get-inputs-schema", "merged-input-sets"}:
                disp, reason = "live_compute", "compute-only POST - persists nothing"
            elif oid in {"create-pipeline", "create-input-set"}:
                disp, reason = "live_create", "creates a uniquely-named throwaway dummy"
            elif oid in DUMMY_LIFECYCLE_ALLOWLIST:
                disp, reason = "live_lifecycle", "edit/delete - runs ONLY on the throwaway dummy this run created"
            elif oid in WRITE_HARD_DENY:
                disp, reason = "skipped_denied", HARD_DENY_REASON.get(oid, "destructive / side-effecting on shared resources")
            else:
                disp, reason = "skipped_unlisted", "write op not on the safe allowlist - left for manual review"
            called_live = disp == "live_get" or (safe_writes and disp.startswith("live_"))
            cov.append({
                "operationId": oid, "method": method.upper(), "path": path,
                "disposition": disp, "reason": reason, "called_live": called_live,
            })
    cov.sort(key=lambda c: (METHOD_ORDER.get(c["method"].lower(), 9), c["path"]))
    return cov


def safe_write_body(operation_id, org, project, dummy_id, dummy_name):
    """Purpose-built, valid request bodies for allowlisted write ops.

    Generic schema-example bodies 400 on create-* (they need real *_yaml), so
    we hand-craft minimal valid payloads here. Returns None to fall back to the
    generic builder.
    """
    if operation_id == "get-steps":
        # All fields optional; an empty filter returns the full step palette.
        return {"step_pallete_module_infos": []}

    if operation_id == "get-inputs-schema":
        # Feed it the dummy pipeline yaml so it has something to introspect.
        return {"pipeline_yaml": _dummy_pipeline_yaml(org, project, dummy_id, dummy_name)}

    if operation_id == "merged-input-sets":
        # No references -> server merges nothing; exercises the endpoint safely.
        return {"input_set_references": [], "with_merged_pipeline_yaml": True}

    if operation_id == "create-pipeline":
        return {
            "identifier": dummy_id,
            "name": dummy_name,
            "description": "Throwaway pipeline created by API drift probe. Safe to delete.",
            "pipeline_yaml": _dummy_pipeline_yaml(org, project, dummy_id, dummy_name),
        }

    if operation_id == "create-input-set":
        return {
            "identifier": dummy_id + "_is",
            "name": dummy_name + " input-set",
            "description": "Throwaway input set created by API drift probe. Safe to delete.",
            "input_set_yaml": _dummy_input_set_yaml(org, project, dummy_id),
        }

    # --- Bucket C: edit ops, body targets the dummy only ---
    # Names are kept identical to the create payload (and to the name inside the
    # YAML): Harness validates that body name == yaml name, and rejects
    # punctuation, so we vary only the description to exercise the edit.
    if operation_id == "update-pipeline":
        return {
            "identifier": dummy_id,
            "name": dummy_name,
            "description": "Updated by API drift probe. Safe to delete.",
            "pipeline_yaml": _dummy_pipeline_yaml(org, project, dummy_id, dummy_name),
        }

    if operation_id == "patch-pipeline":
        # All fields optional; a description tweak is enough to exercise PATCH.
        return {
            "name": dummy_name,
            "desc": "Patched by API drift probe. Safe to delete.",
        }

    if operation_id == "update-input-set":
        return {
            "identifier": dummy_id + "_is",
            "name": dummy_name + " input-set",
            "description": "Updated by API drift probe. Safe to delete.",
            "input_set_yaml": _dummy_input_set_yaml(org, project, dummy_id),
        }

    return None


def _dummy_pipeline_yaml(org, project, pipeline_id, pipeline_name):
    """A minimal, valid pipeline: one Custom stage with a no-op ShellScript.
    Creating it does NOT execute anything; it just persists a definition."""
    return (
        "pipeline:\n"
        f"  name: {pipeline_name}\n"
        f"  identifier: {pipeline_id}\n"
        f"  projectIdentifier: {project}\n"
        f"  orgIdentifier: {org}\n"
        "  tags: {}\n"
        "  stages:\n"
        "    - stage:\n"
        "        name: noop\n"
        "        identifier: noop\n"
        "        type: Custom\n"
        "        spec:\n"
        "          execution:\n"
        "            steps:\n"
        "              - step:\n"
        "                  type: ShellScript\n"
        "                  name: noop\n"
        "                  identifier: noop\n"
        "                  spec:\n"
        "                    shell: Bash\n"
        "                    onDelegate: true\n"
        "                    source:\n"
        "                      type: Inline\n"
        "                      spec:\n"
        "                        script: echo \"drift-probe noop\"\n"
        "                  timeout: 10m\n"
    )


def _dummy_input_set_yaml(org, project, pipeline_id):
    return (
        "inputSet:\n"
        "  name: drift probe input-set\n"
        f"  identifier: {pipeline_id}_is\n"
        f"  orgIdentifier: {org}\n"
        f"  projectIdentifier: {project}\n"
        "  pipeline:\n"
        f"    identifier: {pipeline_id}\n"
    )


def request_body_for(operation, include_body):
    if not include_body:
        return None
    rb = operation.get("requestBody")
    if not isinstance(rb, dict):
        return None
    content = rb.get("content", {}) or {}
    if not isinstance(content, dict):
        return None
    media = content.get("application/json")
    if not isinstance(media, dict):
        media = next((v for v in content.values() if isinstance(v, dict)), {})
    schema = media.get("schema")
    if not isinstance(schema, dict):
        return None
    return example_from_schema(schema)


def main():
    ap = argparse.ArgumentParser(description="Call every API of a Harness module against a sandbox.")
    ap.add_argument("--module", default="pipeline-service", help="Module folder name (default: pipeline-service)")
    ap.add_argument("--spec-dir", default=os.path.dirname(os.path.abspath(__file__)),
                    help="Directory containing the module folders (default: this script's dir)")
    ap.add_argument("--spec-file", default=None, help="Explicit path to an openapi.yaml (overrides --module/--spec-dir)")
    ap.add_argument("--base-url", default=os.getenv("HARNESS_BASE_URL", DEFAULTS["base_url"]))
    ap.add_argument("--account", default=os.getenv("HARNESS_ACCOUNT_ID", DEFAULTS["account"]))
    ap.add_argument("--org", default=os.getenv("HARNESS_ORG", DEFAULTS["org"]))
    ap.add_argument("--project", default=os.getenv("HARNESS_PROJECT", DEFAULTS["project"]))
    ap.add_argument("--api-key", default=os.getenv("HARNESS_API_KEY", DEFAULTS["api_key"]))
    ap.add_argument("--methods", default="get,post,put,patch,delete",
                    help="Comma-separated methods to call (default: all)")
    ap.add_argument("--include-optional-params", action="store_true",
                    help="Also send optional query params that have examples/defaults")
    ap.add_argument("--timeout", type=float, default=30.0)
    ap.add_argument("--max-body", type=int, default=600, help="Chars of each response body kept in the report")
    ap.add_argument("--output", default="api_run_report.json")
    ap.add_argument("--limit", type=int, default=0, help="Cap number of operations called (0 = no cap)")
    ap.add_argument("--dry-run", action="store_true", help="Build requests and print them, but do not send")
    ap.add_argument("--seed", default="seed.json",
                    help="Optional JSON of known-real ids (pipeline, input-set, trigger, ...) "
                         "used to resolve {placeholders} and required query params. Missing file is fine.")
    ap.add_argument("--safe-writes", action="store_true",
                    help="Exercise the full SAFE lifecycle: compute POSTs + create a throwaway "
                         "dummy pipeline/input-set, then edit (PUT/PATCH) and delete it - all scoped "
                         "ONLY to that throwaway. Execute/trigger/git ops stay hard-blocked. "
                         "Pass --methods get,post,put,patch,delete to enable every stage.")
    ap.add_argument("--dummy-id", default=os.getenv("DRIFT_DUMMY_ID", "apidrift_probe"),
                    help="Identifier for the throwaway pipeline created in --safe-writes mode. "
                         "Never points at a working pipeline.")
    args = ap.parse_args()

    # Hard guard: the dummy must never collide with a real/working pipeline id.
    if args.safe_writes and args.dummy_id in {"testab", "testab3"}:
        sys.exit(f"Refusing to use working pipeline id as dummy: {args.dummy_id}")

    spec_path = args.spec_file or os.path.join(args.spec_dir, args.module, "openapi.yaml")
    if not os.path.exists(spec_path):
        sys.exit(f"Spec not found: {spec_path}")

    if not args.api_key and not args.dry_run:
        sys.exit("No API key. Set HARNESS_API_KEY (from a Harness Secret in CI) or pass --api-key.")

    cfg = {"base_url": args.base_url.rstrip("/"), "account": args.account,
           "org": args.org, "project": args.project, "api_key": args.api_key}
    methods_filter = {m.strip().lower() for m in args.methods.split(",") if m.strip()}

    spec = load_spec(spec_path)
    # Server: spec ships app.harness.io; we always target the sandbox base url.
    context = build_context(cfg)
    # Merge optional seed ids on top of the derived context (alias matching handles
    # name variants like pipeline_identifier vs pipeline at lookup time).
    seed = load_seed(args.seed)
    if seed:
        context.update(seed)
        print(f"Seed loaded : {args.seed}  ({len(seed)} keys: {', '.join(sorted(seed))})")
    discovered = {}
    # Per-run UNIQUE dummy id: a random suffix guarantees it can never collide
    # with any real/working pipeline id (and never equals a PROTECTED id).
    run_token = secrets.token_hex(3)
    base_dummy = args.dummy_id or "apidrift_probe"
    dummy_id = f"{base_dummy}_{run_token}"
    dummy_is_id = dummy_id + "_is"
    # Name kept to letters/digits/spaces only - Harness entity-name validation
    # rejects punctuation like parentheses, which returns a 400 on create.
    dummy_name = f"API Drift Probe throwaway {run_token}"

    # PROTECTED ids: real resources that a write/delete must NEVER resolve to.
    # org/project are intentionally NOT here (they appear in every path segment).
    PROTECTED_IDS = {"testab", "testab3"}
    if seed.get("pipeline"):
        PROTECTED_IDS.add(str(seed["pipeline"]))
    created_ids = set()  # only ids THIS run created may be edited / deleted

    operations = collect_operations(spec, methods_filter, safe_writes=args.safe_writes)

    # Dependency ordering for safe writes: the dummy pipeline must be created
    # BEFORE any input-set op that references it (alphabetical path order would
    # otherwise run input-sets first). GETs keep their natural order.
    # Lifecycle order: create the dummy BEFORE editing it, and delete it LAST so
    # the run cleans up after itself (delete-input-set before delete-pipeline).
    SAFE_WRITE_PRIORITY = {
        "create-pipeline": 1, "update-pipeline": 2, "patch-pipeline": 3,
        "create-input-set": 4, "update-input-set": 5,
        "merged-input-sets": 6, "get-steps": 7, "get-inputs-schema": 8,
        "delete-input-set": 90, "delete-pipeline": 99,
    }
    if args.safe_writes:
        operations.sort(key=lambda o: (
            0 if o["method"] == "get" else 1,
            SAFE_WRITE_PRIORITY.get((o["op"] or {}).get("operationId"), 50),
            o["path"],
        ))

    if args.limit and args.limit > 0:
        operations = operations[:args.limit]

    print(f"Module spec : {spec_path}")
    print(f"Base URL    : {cfg['base_url']}")
    print(f"Org/Project : {cfg['org']} / {cfg['project']}")
    print(f"Methods     : {sorted(methods_filter)}")
    if args.safe_writes:
        print(f"Safe-writes : ON  (throwaway dummy = {dummy_id}; edit/delete scoped to it only)")
        print(f"Protected   : {sorted(PROTECTED_IDS)} (never an edit/delete target)")
    print(f"Operations  : {len(operations)}")
    print("-" * 90)

    results = []
    for entry in operations:
        path, method, op, params = entry["path"], entry["method"], entry["op"], entry["params"]
        op_id = op.get("operationId")
        include_body = method in ("post", "put", "patch")

        # Per-call context: for allowlisted write ops, force any {pipeline}
        # placeholder / `pipeline` query param to the DUMMY, so an input-set is
        # never attached to the real working pipeline (e.g. testab3).
        DUMMY_TARGET_OPS = SAFE_WRITE_ALLOWLIST | DUMMY_LIFECYCLE_ALLOWLIST
        is_dummy_op = args.safe_writes and op_id in DUMMY_TARGET_OPS
        category = ("get" if method == "get"
                    else "compute" if op_id in {"get-steps", "get-inputs-schema", "merged-input-sets"}
                    else "create" if op_id in {"create-pipeline", "create-input-set"}
                    else "lifecycle" if op_id in DUMMY_LIFECYCLE_ALLOWLIST
                    else "other")

        call_ctx = context
        call_discovered = discovered
        body = request_body_for(op, include_body)
        if is_dummy_op:
            custom = safe_write_body(op_id, cfg["org"], cfg["project"], dummy_id, dummy_name)
            if custom is not None:
                body = custom
            # CLEAN context: only account/org/project + the dummy ids are visible,
            # and harvested ids are ignored entirely - so a write/delete can never
            # resolve a {pipeline}/{input-set} placeholder to a REAL resource.
            call_ctx = build_context(cfg)
            call_ctx["pipeline"] = dummy_id      # {pipeline} path + ?pipeline= query
            call_ctx["input-set"] = dummy_is_id  # {input-set} path
            call_discovered = {}

        record = {
            "operationId": op_id,
            "method": method.upper(),
            "path": path,
            "summary": op.get("summary"),
            "category": category,
            "target": "dummy" if is_dummy_op else "real",
        }

        # Skip a lifecycle edit/delete if THIS run did not actually create its
        # target - nothing to act on, and it guarantees we only ever touch ours.
        if op_id in DUMMY_LIFECYCLE_ALLOWLIST and not args.dry_run:
            need = dummy_is_id if op_id in {"update-input-set", "delete-input-set"} else dummy_id
            if need not in created_ids:
                record.update({"status": "SKIPPED",
                               "skip_reason": f"throwaway target '{need}' was not created this run"})
                print(f"[skip] {op_id}: target not created -> not editing/deleting")
                results.append(record)
                continue

        rel = fill_path(path, params, call_ctx, call_discovered)
        query = build_query(params, call_ctx, call_discovered, args.include_optional_params)
        url = cfg["base_url"] + rel
        if query:
            url += "?" + urllib.parse.urlencode(query, doseq=True)
        headers = build_headers(op, params, cfg, call_ctx)
        record["url"] = url
        record["sent_body"] = body

        # HARD ABORT guard: before any edit/delete, the resolved path MUST point
        # at our dummy and MUST NOT contain a PROTECTED (real) id. If either check
        # fails something is badly wrong - kill the whole run rather than risk it.
        if op_id in DUMMY_LIFECYCLE_ALLOWLIST:
            segs = [urllib.parse.unquote(s) for s in rel.split("/") if s]
            if dummy_id not in segs and dummy_is_id not in segs:
                sys.exit(f"SAFETY ABORT: {op_id} did not resolve to the dummy: {rel}")
            hit = [s for s in segs if s in PROTECTED_IDS]
            if hit:
                sys.exit(f"SAFETY ABORT: {op_id} would touch protected id {hit}: {rel}")

        if args.dry_run:
            record["status"] = "DRY_RUN"
            print(f"[DRY] {method.upper():6} {url}")
            results.append(record)
            continue

        status, resp_headers, text, elapsed = send(method, url, headers, body, args.timeout)
        parsed = parse_json(text)
        record.update({
            "status": status,
            "elapsed_ms": round(elapsed * 1000, 1),
            "response_snippet": (text or "")[:args.max_body],
        })
        results.append(record)

        # Record successful creates so their matching edit/delete may proceed.
        if isinstance(status, int) and 200 <= status < 300:
            if op_id == "create-pipeline":
                created_ids.add(dummy_id)
            elif op_id == "create-input-set":
                created_ids.add(dummy_is_id)

        # On a successful GET, harvest ids for later dependent (GET) calls only.
        if method == "get" and isinstance(status, int) and 200 <= status < 300 and parsed is not None:
            for k, v in harvest_ids(path, parsed).items():
                discovered.setdefault(k, v)

        flag = "ok " if isinstance(status, int) and 200 <= status < 300 else "ERR"
        print(f"[{flag}] {str(status):>4} {method.upper():6} {rel}  ({record['elapsed_ms']} ms)")
        # On a failed write/create, surface WHY right in the log so failures are
        # diagnosable without digging into the JSON report.
        if flag == "ERR" and method != "get":
            why = (record.get("response_snippet") or "").strip().replace("\n", " ")
            if why:
                print(f"        -> {why[:300]}")

    # Summary
    ok = sum(1 for r in results if isinstance(r.get("status"), int) and 200 <= r["status"] < 300)
    print("-" * 90)
    print(f"Done: {ok}/{len(results)} returned 2xx")

    report = {
        "module": args.module,
        "spec_path": spec_path,
        "base_url": cfg["base_url"],
        "org": cfg["org"],
        "project": cfg["project"],
        "total": len(results),
        "succeeded_2xx": ok,
        "safe_writes": args.safe_writes,
        "dummy_pipeline_id": dummy_id if args.safe_writes else None,
        "dummy_input_set_id": dummy_is_id if args.safe_writes else None,
        "created_throwaways": sorted(created_ids),
        "discovered_ids": discovered,
        "coverage": build_coverage(spec, args.safe_writes),
        "results": results,
    }
    with open(args.output, "w") as fh:
        json.dump(report, fh, indent=2)
    print(f"Full report written to {args.output}")


if __name__ == "__main__":
    main()

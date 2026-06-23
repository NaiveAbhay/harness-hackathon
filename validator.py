#!/usr/bin/env python3
"""
validator.py
============
API Quality & Documentation Drift validator for the Harness OpenAPI specs.

It compares what the docs SAY an API does (the local OpenAPI YAML in this repo)
against what the API ACTUALLY returns (live responses captured by
run_module_apis.py), then produces a ranked drift report.

Drift signals detected
-----------------------
  HIGH    undocumented_status   API returned a status code the spec doesn't list
                                (e.g. 405 on a documented method, or a 5xx).
  HIGH    undocumented_field    A 2xx response body contains fields not in the
                                documented schema (docs are behind the API).
  MEDIUM  broken_example        We sent the spec's own example body and the API
                                rejected it (4xx) -> the documented example is stale.
  MEDIUM  server_error          Documented endpoint returned 5xx.
  LOW     documented_field_absent  A documented field never appeared in the
                                actual response (may be optional, but worth a look).

Usage
-----
  # Uses an existing capture (api_run_report.json). If absent, it runs the
  # collector itself in safe read-only mode (GET only).
  python3 validator.py --module pipeline-service

  # Point at a specific capture file:
  python3 validator.py --module pipeline-service --report-from api_run_report.json

Outputs: drift_report.json (machine) + drift_report.md (human) + console summary.

Dependencies: PyYAML, jsonref
"""

import argparse
import json
import os
import subprocess
import sys

try:
    import yaml
    import jsonref
except ImportError:
    sys.exit("Missing deps. Run: pip install pyyaml jsonref")

HERE = os.path.dirname(os.path.abspath(__file__))
HTTP_METHODS = {"get", "post", "put", "patch", "delete"}

SEVERITY_RANK = {"HIGH": 0, "MEDIUM": 1, "LOW": 2, "INFO": 3}


# --------------------------------------------------------------------------- #
# Loading
# --------------------------------------------------------------------------- #
def load_spec(spec_path):
    with open(spec_path) as fh:
        raw = yaml.safe_load(fh)
    resolved = jsonref.replace_refs(raw, base_uri="file://" + os.path.abspath(spec_path))
    return json.loads(json.dumps(resolved, default=str))


def index_operations(spec):
    """(METHOD, path) -> operation dict."""
    idx = {}
    for path, item in (spec.get("paths") or {}).items():
        if not isinstance(item, dict):
            continue
        for method, op in item.items():
            if method in HTTP_METHODS and isinstance(op, dict):
                idx[(method.upper(), path)] = op
    return idx


def ensure_report(args):
    """Return the capture report dict, generating it (GET-only) if needed."""
    path = args.report_from
    if path and os.path.exists(path):
        with open(path) as fh:
            return json.load(fh)
    # Generate a fresh capture safely (read-only) using the sibling collector.
    runner = os.path.join(HERE, "run_module_apis.py")
    out = args.report_from or "api_run_report.json"
    print(f"No capture found; running collector (GET only) -> {out}")
    subprocess.run(
        [sys.executable, runner, "--module", args.module, "--methods", "get", "--output", out],
        check=True,
    )
    with open(out) as fh:
        return json.load(fh)


# --------------------------------------------------------------------------- #
# Schema helpers
# --------------------------------------------------------------------------- #
def json_schema_for_status(operation, status):
    """Return the documented application/json schema for a given status code."""
    responses = operation.get("responses") or {}
    candidates = [str(status), f"{str(status)[0]}XX", f"{str(status)[0]}xx", "default"]
    for key in candidates:
        if key in responses and isinstance(responses[key], dict):
            content = responses[key].get("content") or {}
            media = content.get("application/json")
            if isinstance(media, dict) and isinstance(media.get("schema"), dict):
                return media["schema"]
    return None


def documented_status_codes(operation):
    out = set()
    for key in (operation.get("responses") or {}):
        if str(key).isdigit():
            out.add(int(key))
    return out


def status_is_documented(operation, status):
    responses = operation.get("responses") or {}
    if str(status) in responses or "default" in responses:
        return True
    fam = f"{str(status)[0]}XX"
    return fam in responses or fam.lower() in responses


def object_schema_props(schema):
    """Given a schema (possibly an array of objects), return (props, additionalProps_open)."""
    if not isinstance(schema, dict):
        return None, True
    if schema.get("type") == "array" or "items" in schema:
        schema = schema.get("items", {}) or {}
    if not isinstance(schema, dict):
        return None, True
    if schema.get("type") == "object" or "properties" in schema:
        props = set((schema.get("properties") or {}).keys())
        addl = schema.get("additionalProperties", True)
        return props, (bool(addl) if not isinstance(addl, dict) else True)
    return None, True


def sample_objects(body):
    """Pull representative object(s) out of a response body for field comparison."""
    if isinstance(body, list):
        return [x for x in body[:5] if isinstance(x, dict)]
    if isinstance(body, dict):
        # Common envelope: a list nested under some key.
        for v in body.values():
            if isinstance(v, list) and v and isinstance(v[0], dict):
                return [x for x in v[:5] if isinstance(x, dict)]
        return [body]
    return []


def has_documented_example(operation):
    rb = operation.get("requestBody")
    if not isinstance(rb, dict):
        return False
    for media in (rb.get("content") or {}).values():
        if not isinstance(media, dict):
            continue
        if "example" in media or "examples" in media:
            return True
        sch = media.get("schema")
        if isinstance(sch, dict) and ("example" in sch or "x-examples" in sch):
            return True
    return False


# --------------------------------------------------------------------------- #
# Drift analysis
# --------------------------------------------------------------------------- #
def parse_snippet(result):
    """The capture stores a truncated 'response_snippet'; parse if it's whole JSON."""
    snip = result.get("response_snippet")
    if not snip:
        return None
    try:
        return json.loads(snip)
    except Exception:  # noqa: BLE001 - snippet may be truncated mid-JSON
        return None


def analyze(result, operation):
    """Return a list of finding dicts for one captured call."""
    findings = []
    method, path = result.get("method"), result.get("path")
    status = result.get("status")
    op_id = result.get("operationId")
    loc = {"operationId": op_id, "method": method, "path": path, "status": status}

    if not isinstance(status, int):
        return findings  # transport error, not a doc-drift signal

    # --- status code drift -------------------------------------------------- #
    if not status_is_documented(operation, status):
        if status == 405:
            sev = "HIGH"
            note = "Spec documents this method but the server returned 405 Method Not Allowed."
        elif status >= 500:
            sev = "HIGH"
            note = "Undocumented server error (5xx) on a documented endpoint."
        elif status in (400, 404):
            sev = "LOW"
            note = ("Status not documented, but this call used placeholder path/query "
                    "values, so the error may be input-related rather than true drift.")
        else:
            sev = "MEDIUM"
            note = "Returned status code is not listed in the spec's responses."
        findings.append({**loc, "type": "undocumented_status", "severity": sev,
                         "documented": sorted(documented_status_codes(operation)),
                         "detail": note})

    # --- broken documented example ----------------------------------------- #
    if 400 <= status < 500 and has_documented_example(operation) and result.get("sent_body"):
        findings.append({**loc, "type": "broken_example", "severity": "MEDIUM",
                         "detail": "Request built from the spec's documented example was "
                                   f"rejected with {status}; the documented example looks stale."})

    # --- server error on documented endpoint ------------------------------- #
    if status >= 500 and status_is_documented(operation, status):
        findings.append({**loc, "type": "server_error", "severity": "MEDIUM",
                         "detail": "Documented endpoint returned a 5xx server error."})

    # --- field-level drift on success bodies -------------------------------- #
    if 200 <= status < 300:
        body = parse_snippet(result)
        schema = json_schema_for_status(operation, status)
        doc_props, addl_open = object_schema_props(schema)
        objs = sample_objects(body) if body is not None else []
        if doc_props is not None and objs:
            actual_props = set()
            for o in objs:
                actual_props |= set(o.keys())
            undocumented = sorted(actual_props - doc_props)
            absent = sorted(doc_props - actual_props)
            if undocumented and not addl_open:
                findings.append({**loc, "type": "undocumented_field", "severity": "HIGH",
                                 "fields": undocumented,
                                 "detail": "Response returns fields not present in the documented schema."})
            elif undocumented:
                findings.append({**loc, "type": "undocumented_field", "severity": "MEDIUM",
                                 "fields": undocumented,
                                 "detail": "Response returns fields not present in the documented schema "
                                           "(schema allows additional properties)."})
            if absent:
                findings.append({**loc, "type": "documented_field_absent", "severity": "LOW",
                                 "fields": absent,
                                 "detail": "Documented fields did not appear in the actual response "
                                           "(may be optional/empty)."})
    return findings


# --------------------------------------------------------------------------- #
# Reporting
# --------------------------------------------------------------------------- #
def write_markdown(report, path):
    f = report["findings"]
    lines = []
    lines.append(f"# API Documentation Drift Report - `{report['module']}`\n")
    lines.append(f"- Spec: `{report['spec_path']}`")
    lines.append(f"- Base URL: {report['base_url']}")
    lines.append(f"- Operations analyzed: {report['operations_analyzed']}")
    lines.append(f"- Total findings: {report['total_findings']} "
                 f"(HIGH {report['by_severity'].get('HIGH',0)}, "
                 f"MEDIUM {report['by_severity'].get('MEDIUM',0)}, "
                 f"LOW {report['by_severity'].get('LOW',0)})\n")
    if not f:
        lines.append("No drift detected.\n")
    else:
        lines.append("| # | Severity | Type | Method | Path | Detail |")
        lines.append("|---|----------|------|--------|------|--------|")
        for i, x in enumerate(f, 1):
            extra = ""
            if x.get("fields"):
                extra = " Fields: `" + "`, `".join(x["fields"][:8]) + "`."
            detail = (x.get("detail", "") + extra).replace("|", "\\|")
            lines.append(f"| {i} | {x['severity']} | {x['type']} | {x['method']} | "
                         f"`{x['path']}` | {detail} |")
    with open(path, "w") as fh:
        fh.write("\n".join(lines) + "\n")


def main():
    ap = argparse.ArgumentParser(description="Detect drift between Harness OpenAPI docs and live API behavior.")
    ap.add_argument("--module", default="pipeline-service")
    ap.add_argument("--spec-dir", default=HERE)
    ap.add_argument("--spec-file", default=None)
    ap.add_argument("--report-from", default="api_run_report.json",
                    help="Capture file from run_module_apis.py (generated GET-only if missing)")
    ap.add_argument("--output-json", default="drift_report.json")
    ap.add_argument("--output-md", default="drift_report.md")
    ap.add_argument("--fail-on", choices=["none", "HIGH", "MEDIUM", "LOW"], default="none",
                    help="Exit non-zero (fail the CI step) if findings at/above this severity exist.")
    args = ap.parse_args()

    spec_path = args.spec_file or os.path.join(args.spec_dir, args.module, "openapi.yaml")
    if not os.path.exists(spec_path):
        sys.exit(f"Spec not found: {spec_path}")

    spec = load_spec(spec_path)
    ops = index_operations(spec)
    capture = ensure_report(args)

    findings, analyzed, unmatched = [], 0, []
    for result in capture.get("results", []):
        key = (result.get("method"), result.get("path"))
        operation = ops.get(key)
        if operation is None:
            unmatched.append(key)
            continue
        analyzed += 1
        findings.extend(analyze(result, operation))

    findings.sort(key=lambda x: (SEVERITY_RANK.get(x["severity"], 9), x["type"], x["path"]))
    by_sev = {}
    for x in findings:
        by_sev[x["severity"]] = by_sev.get(x["severity"], 0) + 1

    report = {
        "module": args.module,
        "spec_path": spec_path,
        "base_url": capture.get("base_url"),
        "operations_analyzed": analyzed,
        "operations_unmatched": [f"{m} {p}" for m, p in unmatched],
        "total_findings": len(findings),
        "by_severity": by_sev,
        "findings": findings,
    }
    with open(args.output_json, "w") as fh:
        json.dump(report, fh, indent=2)
    write_markdown(report, args.output_md)

    # Console summary
    print("=" * 80)
    print(f"DRIFT REPORT - {args.module}")
    print(f"Operations analyzed: {analyzed} | Findings: {len(findings)} "
          f"(HIGH {by_sev.get('HIGH',0)}, MEDIUM {by_sev.get('MEDIUM',0)}, LOW {by_sev.get('LOW',0)})")
    print("-" * 80)
    for x in findings[:30]:
        flds = (" " + ",".join(x["fields"][:6])) if x.get("fields") else ""
        print(f"[{x['severity']:6}] {x['type']:22} {x['method']:6} {x['path']}{flds}")
    if len(findings) > 30:
        print(f"... and {len(findings)-30} more (see {args.output_md})")
    print("-" * 80)
    print(f"Wrote {args.output_json} and {args.output_md}")

    # Quality gate: optionally fail the CI step based on severity.
    if args.fail_on != "none":
        threshold = SEVERITY_RANK[args.fail_on]
        gating = sum(1 for x in findings if SEVERITY_RANK.get(x["severity"], 9) <= threshold)
        if gating:
            print(f"QUALITY GATE FAILED: {gating} drift finding(s) at or above {args.fail_on}.")
            sys.exit(1)
        print(f"QUALITY GATE PASSED: no drift at or above {args.fail_on}.")


if __name__ == "__main__":
    main()

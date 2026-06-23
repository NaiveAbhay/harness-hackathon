#!/usr/bin/env python3
"""
static_validator.py
===================
STATIC documentation-quality validation for the Harness OpenAPI specs.

apidocs.harness.io is rendered directly from the harness-openapi spec, so
problems in the spec are problems in the docs. This tool reads the local spec
files (no live API calls, no writes -- completely safe) and flags 11 classes of
documentation defect, then emits a ranked report telling the docs team what to
fix first.

Checks
------
  HIGH  INTERNAL_LEAK            x-internal: true on an operation in the public spec
  LOW   MISSING_SUMMARY          operation summary empty -> blank title in docs nav
  MED   PLACEHOLDER_TEXT         summary/description contains TODO, TBD, lorem ipsum, FIXME...
  MED   UNFLAGGED_DEPRECATION    text says "deprecated" but the `deprecated` flag isn't set
  MED   MISSING_DESCRIPTION      operation description empty
  HIGH  NO_SUCCESS_RESPONSE      no 2xx response documented
  MED   NO_ERROR_RESPONSES       no 4xx/5xx response documented
  LOW   MISSING_REQUEST_EXAMPLE  write op (POST/PUT/PATCH) has a body but no example
  LOW   UNDOCUMENTED_PARAM       a parameter has no description
  MED   SERVERS_MISSING          spec has no servers: block (no base URL) [spec-level]
  HIGH  DUPLICATE_OPERATION_ID   same operationId used twice [spec-level + cross-spec]

Usage
-----
  python3 static_validator.py                 # all modules in this repo
  python3 static_validator.py --module pipeline-service
  python3 static_validator.py --spec-file ng-manager/openapi.yaml

Outputs: static_report.json + static_report.md + console summary.
Dependencies: PyYAML, jsonref
"""

import argparse
import glob
import json
import os
import re
import sys

try:
    import yaml
    import jsonref
except ImportError:
    sys.exit("Missing deps. Run: pip install pyyaml jsonref")

HERE = os.path.dirname(os.path.abspath(__file__))
HTTP_METHODS = ("get", "post", "put", "patch", "delete")
WRITE_METHODS = ("post", "put", "patch")
SEVERITY_RANK = {"HIGH": 0, "MED": 1, "LOW": 2}

PLACEHOLDER_PATTERNS = [
    r"\btodo\b", r"\btbd\b", r"\bfixme\b", r"\bxxx\b",
    r"lorem ipsum", r"\bplaceholder\b", r"coming soon", r"\bwip\b",
]
PLACEHOLDER_RE = re.compile("|".join(PLACEHOLDER_PATTERNS), re.IGNORECASE)
DEPRECATED_RE = re.compile(r"\bdeprecat", re.IGNORECASE)


def load_spec(path):
    """Load YAML and resolve $refs (guarded against unresolved-ref stringification)."""
    with open(path) as fh:
        raw = yaml.safe_load(fh)
    resolved = jsonref.replace_refs(raw, base_uri="file://" + os.path.abspath(path))
    return json.loads(json.dumps(resolved, default=str))


def text_of(op):
    return " ".join(str(op.get(k) or "") for k in ("summary", "description"))


def has_request_example(operation):
    rb = operation.get("requestBody")
    if not isinstance(rb, dict):
        return None  # no body at all
    content = rb.get("content")
    if not isinstance(content, dict) or not content:
        return None
    for media in content.values():
        if not isinstance(media, dict):
            continue
        if media.get("example") is not None or media.get("examples"):
            return True
        sch = media.get("schema")
        if isinstance(sch, dict) and (sch.get("example") is not None or sch.get("x-examples")):
            return True
    return False  # body exists but no example


def iter_operations(spec):
    """Yield (path, method, operation, merged_params)."""
    for path, item in (spec.get("paths") or {}).items():
        if not isinstance(item, dict):
            continue
        shared = [p for p in (item.get("parameters") or []) if isinstance(p, dict)]
        for method, op in item.items():
            if method in HTTP_METHODS and isinstance(op, dict):
                params = shared + [p for p in (op.get("parameters") or []) if isinstance(p, dict)]
                yield path, method, op, params


def check_spec(module, spec, findings, global_opids):
    """Run all checks for a single module spec; append to findings list."""
    # ---- spec-level: servers block ---------------------------------------- #
    if not spec.get("servers"):
        findings.append({"check": "SERVERS_MISSING", "severity": "MED", "module": module,
                         "path": "(spec)", "method": "", "operationId": "",
                         "detail": "Spec has no servers: block; docs have no base URL to show."})

    local_opids = {}
    for path, method, op, params in iter_operations(spec):
        op_id = op.get("operationId") or ""
        loc = {"module": module, "path": path, "method": method.upper(), "operationId": op_id}
        txt = text_of(op)

        # 1. INTERNAL_LEAK
        if op.get("x-internal") is True:
            findings.append({**loc, "check": "INTERNAL_LEAK", "severity": "HIGH",
                             "detail": "Operation marked x-internal: true is present in the public spec."})
        # 2. MISSING_SUMMARY
        if not (op.get("summary") or "").strip():
            findings.append({**loc, "check": "MISSING_SUMMARY", "severity": "LOW",
                             "detail": "Empty summary -> blank title in the docs navigation."})
        # 3. PLACEHOLDER_TEXT
        if PLACEHOLDER_RE.search(txt):
            hit = PLACEHOLDER_RE.search(txt).group(0)
            findings.append({**loc, "check": "PLACEHOLDER_TEXT", "severity": "MED",
                             "detail": f"Summary/description contains placeholder text: '{hit}'."})
        # 4. UNFLAGGED_DEPRECATION
        if DEPRECATED_RE.search(txt) and op.get("deprecated") is not True:
            findings.append({**loc, "check": "UNFLAGGED_DEPRECATION", "severity": "MED",
                             "detail": "Text mentions 'deprecated' but the operation's deprecated flag is not set."})
        # 5. MISSING_DESCRIPTION
        if not (op.get("description") or "").strip():
            findings.append({**loc, "check": "MISSING_DESCRIPTION", "severity": "MED",
                             "detail": "Operation has no description."})
        # 6/7. response coverage
        responses = op.get("responses") or {}
        codes = [str(k) for k in responses]
        if not any(c.startswith("2") for c in codes):
            findings.append({**loc, "check": "NO_SUCCESS_RESPONSE", "severity": "HIGH",
                             "detail": "No 2xx response documented; customers can't tell what success looks like."})
        if not any(c[:1] in ("4", "5") for c in codes) and "default" not in responses:
            findings.append({**loc, "check": "NO_ERROR_RESPONSES", "severity": "MED",
                             "detail": "No 4xx/5xx (or default) error response documented."})
        # 8. MISSING_REQUEST_EXAMPLE (write ops only)
        if method in WRITE_METHODS:
            ex = has_request_example(op)
            if ex is False:
                findings.append({**loc, "check": "MISSING_REQUEST_EXAMPLE", "severity": "LOW",
                                 "detail": "Write operation has a request body but no example to copy-paste."})
        # 9. UNDOCUMENTED_PARAM
        undoc = [p.get("name") for p in params if not (p.get("description") or "").strip()]
        undoc = [n for n in undoc if n]
        if undoc:
            findings.append({**loc, "check": "UNDOCUMENTED_PARAM", "severity": "LOW",
                             "params": undoc,
                             "detail": f"{len(undoc)} parameter(s) have no description: {', '.join(undoc[:6])}"
                                       + ("..." if len(undoc) > 6 else "")})

        # operationId bookkeeping (for duplicate detection)
        if op_id:
            local_opids.setdefault(op_id, []).append(f"{method.upper()} {path}")
            global_opids.setdefault(op_id, []).append(f"{module}: {method.upper()} {path}")

    # 11. DUPLICATE_OPERATION_ID within this spec
    for op_id, where in local_opids.items():
        if len(where) > 1:
            findings.append({"check": "DUPLICATE_OPERATION_ID", "severity": "HIGH", "module": module,
                             "path": "; ".join(where), "method": "", "operationId": op_id,
                             "detail": f"operationId '{op_id}' used {len(where)} times in this spec; breaks SDK codegen."})


def write_markdown(report, path, per_check_cap=25):
    f = report["findings"]
    lines = [f"# Static API Documentation Report\n",
             f"- Scope: {report['scope']}",
             f"- Modules analyzed: {report['modules_analyzed']}",
             f"- Operations analyzed: {report['operations_analyzed']}",
             f"- Total issues: {report['total_findings']} "
             f"(HIGH {report['by_severity'].get('HIGH',0)}, "
             f"MED {report['by_severity'].get('MED',0)}, "
             f"LOW {report['by_severity'].get('LOW',0)})\n",
             "## Issues by check\n",
             "| Check | Severity | Count |", "|-------|----------|-------|"]
    for check, info in sorted(report["by_check"].items(), key=lambda kv: (SEVERITY_RANK[kv[1]['severity']], -kv[1]['count'])):
        lines.append(f"| {check} | {info['severity']} | {info['count']} |")

    # Cross-spec duplicate operationIds get their own section.
    if report["cross_spec_duplicate_operation_ids"]:
        lines.append("\n## Cross-spec duplicate operationIds (HIGH)\n")
        lines.append("| operationId | Used in |")
        lines.append("|-------------|---------|")
        for op_id, where in report["cross_spec_duplicate_operation_ids"].items():
            lines.append(f"| `{op_id}` | {'; '.join(where)} |")

    lines.append("\n## Findings (top by severity)\n")
    lines.append("| # | Severity | Check | Module | Method | Path | Detail |")
    lines.append("|---|----------|-------|--------|--------|------|--------|")
    shown = {}
    i = 0
    for x in f:
        c = x["check"]
        shown[c] = shown.get(c, 0) + 1
        if shown[c] > per_check_cap:
            continue
        i += 1
        detail = x.get("detail", "").replace("|", "\\|")
        path_disp = (x.get("path") or "")[:80]
        lines.append(f"| {i} | {x['severity']} | {c} | {x.get('module','')} | "
                     f"{x.get('method','')} | `{path_disp}` | {detail} |")
    lines.append(f"\n_Showing up to {per_check_cap} rows per check; full detail in static_report.json._\n")
    with open(path, "w") as fh:
        fh.write("\n".join(lines) + "\n")


def main():
    ap = argparse.ArgumentParser(description="Static documentation-quality checks for Harness OpenAPI specs.")
    ap.add_argument("--module", default=None, help="Single module folder (default: all modules)")
    ap.add_argument("--spec-dir", default=HERE)
    ap.add_argument("--spec-file", default=None, help="Explicit openapi.yaml path")
    ap.add_argument("--output-json", default="static_report.json")
    ap.add_argument("--output-md", default="static_report.md")
    args = ap.parse_args()

    if args.spec_file:
        spec_files = [args.spec_file]
    elif args.module:
        spec_files = [os.path.join(args.spec_dir, args.module, "openapi.yaml")]
    else:
        spec_files = sorted(glob.glob(os.path.join(args.spec_dir, "*", "openapi.yaml")))
        # skip the generated/merged bundle to avoid double-counting
        spec_files = [f for f in spec_files if os.path.basename(os.path.dirname(f)) != "_merged"]

    findings, global_opids = [], {}
    modules, total_ops = 0, 0
    for sf in spec_files:
        if not os.path.exists(sf):
            print(f"skip (not found): {sf}")
            continue
        module = os.path.basename(os.path.dirname(sf))
        try:
            spec = load_spec(sf)
        except Exception as e:  # noqa: BLE001
            print(f"skip (parse error) {sf}: {e}")
            continue
        modules += 1
        total_ops += sum(1 for _ in iter_operations(spec))
        check_spec(module, spec, findings, global_opids)

    # cross-spec duplicate operationIds
    cross_dups = {k: v for k, v in global_opids.items()
                  if len({w.split(":")[0] for w in v}) > 1}
    for op_id, where in cross_dups.items():
        findings.append({"check": "DUPLICATE_OPERATION_ID", "severity": "HIGH", "module": "(cross-spec)",
                         "path": "; ".join(where), "method": "", "operationId": op_id,
                         "detail": f"operationId '{op_id}' reused across modules; breaks SDK codegen."})

    findings.sort(key=lambda x: (SEVERITY_RANK[x["severity"]], x["check"], x.get("module", "")))

    by_sev, by_check = {}, {}
    for x in findings:
        by_sev[x["severity"]] = by_sev.get(x["severity"], 0) + 1
        bc = by_check.setdefault(x["check"], {"severity": x["severity"], "count": 0})
        bc["count"] += 1

    report = {
        "scope": args.module or (os.path.basename(args.spec_file) if args.spec_file else "all modules"),
        "modules_analyzed": modules,
        "operations_analyzed": total_ops,
        "total_findings": len(findings),
        "by_severity": by_sev,
        "by_check": by_check,
        "cross_spec_duplicate_operation_ids": cross_dups,
        "findings": findings,
    }
    with open(args.output_json, "w") as fh:
        json.dump(report, fh, indent=2)
    write_markdown(report, args.output_md)

    # console summary
    print("=" * 78)
    print("STATIC DOC REPORT  |  scope:", report["scope"])
    print(f"Modules: {modules}  Operations: {total_ops}  Issues: {len(findings)} "
          f"(HIGH {by_sev.get('HIGH',0)}, MED {by_sev.get('MED',0)}, LOW {by_sev.get('LOW',0)})")
    print("-" * 78)
    for check, info in sorted(by_check.items(), key=lambda kv: (SEVERITY_RANK[kv[1]['severity']], -kv[1]['count'])):
        print(f"  {info['severity']:4}  {check:24} {info['count']:>5}")
    print("-" * 78)
    print(f"Wrote {args.output_json} and {args.output_md}")


if __name__ == "__main__":
    main()

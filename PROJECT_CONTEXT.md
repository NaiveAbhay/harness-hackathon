# API Quality & Documentation Validation — Project Handoff

A Harness hackathon project that detects **drift between Harness's published OpenAPI
docs and the actual API behavior**, plus **static quality checks on the spec itself**.
Two layers of validation, wired into a Harness CI pipeline that produces an HTML dashboard.

> To get up to speed fast: read this file top to bottom, or paste it into a fresh Claude
> session and say "this is the project I'm continuing — help me with X."

---

## What it does (the pitch)

OpenAPI docs drift away from reality over time: an endpoint gets deprecated, a response
gains a field, a documented example goes stale. This tool catches that two ways:

1. **Static validation** — reads the OpenAPI spec and runs 11 documentation-quality
   checks (no API calls). Catches problems in the docs themselves.
2. **Live validation** — calls the real APIs (GET only) and compares responses against
   what the spec promises. Catches drift between docs and reality.

Both emit JSON + Markdown reports, which a dashboard step turns into a single
self-contained HTML page.

---

## Repo layout (scripts live at repo root)

| File | Purpose |
|------|---------|
| `static_validator.py` | The 11 static doc checks. No API calls (safe). Runs across all 13 modules by default, or one via `--module`. Outputs `static_report.json` / `.md`. |
| `run_module_apis.py` | Loads a module's local `openapi.yaml`, dereferences `$ref`s, overrides the server with the sandbox base URL, fires requests at each operation, captures responses to `api_run_report.json`. |
| `validator.py` | Live drift detector. Compares the capture report vs. the spec. Outputs `drift_report.json` / `.md`. Has a `--fail-on` quality gate. |
| `build_dashboard.py` | Pure-stdlib script. Reads `static_report.json` + `drift_report.json`, emits a self-contained `dashboard.html` (inline CSS/JS, no deps). |
| `<module>/openapi.yaml` | The 13 Harness module specs (ng-manager, pipeline-service, etc.). |

---

## The 11 static checks

`INTERNAL_LEAK` (HIGH), `MISSING_SUMMARY` (LOW), `PLACEHOLDER_TEXT` (MED),
`UNFLAGGED_DEPRECATION` (MED), `MISSING_DESCRIPTION` (MED), `NO_SUCCESS_RESPONSE` (HIGH),
`NO_ERROR_RESPONSES` (MED), `MISSING_REQUEST_EXAMPLE` (LOW), `UNDOCUMENTED_PARAM` (LOW),
`SERVERS_MISSING` (MED), `DUPLICATE_OPERATION_ID` (HIGH, spec-level + cross-spec).

## Live drift finding types

`undocumented_status` (405/5xx = HIGH, 400/404 = LOW, else MED), `broken_example` (MED),
`server_error` (MED), `undocumented_field` (HIGH if schema closed, MED if open),
`documented_field_absent` (LOW).

---

## How to run locally

```bash
pip install pyyaml jsonref requests
# static (no API calls, safe)
python static_validator.py --module pipeline-service
# live: call GET endpoints, then detect drift
python run_module_apis.py --module pipeline-service --methods get
python validator.py --module pipeline-service --report-from api_run_report.json
# dashboard
python build_dashboard.py --static static_report.json --drift drift_report.json --output dashboard.html
open dashboard.html
```

**Hard rule: read-only. Only call GET. Never run DELETE/PUT/POST against the sandbox.**
(`run_module_apis.py` defaults to all methods; always pass `--methods get`.)

---

## The Harness pipeline (`testab3`)

A CI pipeline in org `bootcampjune2026`, project `Wakanda`, that clones this repo and
runs the validators. Four `Run` steps, all on the same Kubernetes stage:

1. `static_checks` — pip install deps, then run `static_validator.py`
2. `live_checks` — pip install deps, run `run_module_apis.py --methods get`, then `validator.py`
3. `publish_reports` — `cat` both `.md` reports to the logs
4. `build_dashboard` — run `build_dashboard.py`, emit `dashboard.html`

### Key Harness lessons baked in
- **Each CI step runs in its own container.** Steps share the *workspace files* but NOT
  installed packages — so `pip install` must happen at the top of *every* step that needs it.
- **Cloud vs. Kubernetes runtime** differ only in the stage's infrastructure block. On
  Kubernetes each `Run` step must also specify a container `image` + `connectorRef`
  (here: `bitnami/python:latest` via `account.dockerHub`).
- This project uses **KubernetesDirect**, connector `account.btteamcluster`,
  namespace `harness-delegate-ng`.

---

## Config (sandbox — credentials redacted)

- Base URL: `https://bootcamp-playground.pr2.harness.io`
- Account ID: `<REDACTED — ask Abhay>`
- API key: `<REDACTED — PAT, ask Abhay; format is pat.<accountId>.<tokenId>.<secret>>`
- Org: `bootcampjune2026`  ·  Project: `Wakanda`

Note: the OpenAPI spec documents `https://app.harness.io` as its server, but the scripts
**override** that with the sandbox base URL. The PAT is scoped to the account on the
bootcamp-playground cluster, so it only authenticates against that host — not production.

---

## Open next steps
- Turn on the quality gate: add `--fail-on HIGH` to the **live** step (not static — static
  has ~345 HIGH findings across all modules and would always fail the build).
- Move the API key into a Harness **Secret** (`<+secrets.getValue(...)>`) instead of
  hardcoding it.
- Replace the base64-in-logs dashboard delivery with a proper **Upload Artifacts** step
  so `dashboard.html` is downloadable from the execution page.
- Optionally add a 12th check: does the spec's `servers` list match the environment
  actually tested?

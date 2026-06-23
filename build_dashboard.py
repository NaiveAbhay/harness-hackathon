#!/usr/bin/env python3
"""
build_dashboard.py  --  API Quality & Documentation Validation dashboard.

Reads the two report JSON files produced by the validators and emits a single
self-contained HTML page (inline CSS + JS, no external CDN, no dependencies).

  static_report.json  <- static_validator.py   (spec/doc quality checks)
  drift_report.json   <- validator.py           (live API vs docs drift)

Either file may be absent; the dashboard just shows whichever sections exist.

Usage:
  python build_dashboard.py
  python build_dashboard.py --static static_report.json --drift drift_report.json --output dashboard.html

Pure standard library so it runs anywhere the validators run (CI included).
"""
import argparse
import html
import json
import os
from datetime import datetime, timezone

# Static uses MED, drift uses MEDIUM -- normalise to one vocabulary for display.
SEV_NORM = {"HIGH": "HIGH", "MED": "MEDIUM", "MEDIUM": "MEDIUM", "LOW": "LOW", "INFO": "INFO"}
SEV_ORDER = {"HIGH": 0, "MEDIUM": 1, "LOW": 2, "INFO": 3}
SEV_COLOR = {"HIGH": "#e5484d", "MEDIUM": "#f5a623", "LOW": "#3b82f6", "INFO": "#8b8d98"}


def load(path):
    if not path or not os.path.exists(path):
        return None
    try:
        with open(path) as fh:
            return json.load(fh)
    except (json.JSONDecodeError, OSError):
        return None


def norm_sev(s):
    return SEV_NORM.get((s or "").upper(), "INFO")


def esc(v):
    return html.escape(str(v if v is not None else ""))


def sev_badge(sev):
    sev = norm_sev(sev)
    return f'<span class="badge" style="background:{SEV_COLOR[sev]}">{sev}</span>'


def card(label, value, color=None):
    style = f' style="color:{color}"' if color else ""
    return (f'<div class="card"><div class="card-val"{style}>{esc(value)}</div>'
            f'<div class="card-lbl">{esc(label)}</div></div>')


def severity_bar(by_sev):
    """Normalised severity counts -> a single stacked proportion bar + legend."""
    counts = {}
    for k, v in (by_sev or {}).items():
        counts[norm_sev(k)] = counts.get(norm_sev(k), 0) + v
    total = sum(counts.values()) or 1
    segs, legend = [], []
    for sev in ("HIGH", "MEDIUM", "LOW", "INFO"):
        n = counts.get(sev, 0)
        if not n:
            continue
        pct = 100.0 * n / total
        segs.append(f'<div style="width:{pct:.2f}%;background:{SEV_COLOR[sev]}" '
                    f'title="{sev}: {n}"></div>')
        legend.append(f'<span class="leg"><i style="background:{SEV_COLOR[sev]}"></i>'
                      f'{sev} <b>{n}</b></span>')
    if not segs:
        return '<p class="muted">No findings.</p>'
    return f'<div class="bar">{"".join(segs)}</div><div class="legend">{"".join(legend)}</div>'


def findings_table(findings, columns):
    """columns: list of (json_key, header). Always rows are pre-sorted by caller."""
    head = "".join(f"<th>{esc(h)}</th>" for _, h in columns)
    rows = []
    for f in findings:
        sev = norm_sev(f.get("severity"))
        cells = []
        for key, _ in columns:
            if key == "severity":
                cells.append(f"<td>{sev_badge(sev)}</td>")
            elif key == "fields" or key == "documented":
                val = f.get(key)
                txt = ", ".join(str(x) for x in val) if isinstance(val, list) else esc(val)
                cells.append(f'<td class="mono">{esc(txt)}</td>')
            else:
                cells.append(f"<td>{esc(f.get(key, ''))}</td>")
        rows.append(f'<tr data-sev="{sev}">{"".join(cells)}</tr>')
    return (f'<table><thead><tr>{head}</tr></thead>'
            f'<tbody>{"".join(rows)}</tbody></table>')


def sort_findings(findings):
    return sorted(findings or [],
                  key=lambda x: (SEV_ORDER.get(norm_sev(x.get("severity")), 9),
                                 str(x.get("check") or x.get("type") or ""),
                                 str(x.get("path") or "")))


def filter_buttons(prefix):
    btns = ['<button class="filt active" data-f="ALL">All</button>']
    for sev in ("HIGH", "MEDIUM", "LOW"):
        btns.append(f'<button class="filt" data-f="{sev}" '
                    f'style="border-color:{SEV_COLOR[sev]}">{sev}</button>')
    return f'<div class="filters" data-scope="{prefix}">{"".join(btns)}</div>'


def build_html(static, drift):
    now = datetime.now(timezone.utc).strftime("%Y-%m-%d %H:%M UTC")
    parts = []

    # ---- header + top-level KPI cards ----
    s_total = static.get("total_findings", 0) if static else 0
    d_total = drift.get("total_findings", 0) if drift else 0
    s_high = (static or {}).get("by_severity", {}).get("HIGH", 0)
    d_high = (drift or {}).get("by_severity", {}).get("HIGH", 0)
    scope = (static or {}).get("scope") or (drift or {}).get("module") or "all modules"

    parts.append(f"""
<header>
  <h1>API Quality &amp; Documentation Validation</h1>
  <p class="sub">Scope: <b>{esc(scope)}</b> &nbsp;&middot;&nbsp; Generated {esc(now)}</p>
</header>
<section class="cards">
  {card("Static doc findings", s_total)}
  {card("Static HIGH", s_high, SEV_COLOR["HIGH"])}
  {card("Live drift findings", d_total)}
  {card("Drift HIGH", d_high, SEV_COLOR["HIGH"])}
</section>
""")

    # ---- live drift section (the headline signal) ----
    if drift:
        df = sort_findings(drift.get("findings", []))
        parts.append(f"""
<section class="panel">
  <h2>Live API drift <span class="muted">&mdash; what the API does vs. what the docs say</span></h2>
  <p class="meta">Base URL <span class="mono">{esc(drift.get("base_url",""))}</span>
     &middot; operations analyzed <b>{esc(drift.get("operations_analyzed",0))}</b>
     &middot; unmatched <b>{esc(len(drift.get("operations_unmatched", [])))}</b></p>
  {severity_bar(drift.get("by_severity"))}
  {filter_buttons("drift")}
  <div class="tbl" data-scope="drift">
    {findings_table(df, [("severity","Sev"),("type","Type"),("method","Method"),
                         ("path","Path"),("status","Status"),
                         ("fields","Fields / Documented"),("detail","Detail")]) if df
     else '<p class="muted">No drift findings.</p>'}
  </div>
</section>
""")

    # ---- static doc section ----
    if static:
        sf = sort_findings(static.get("findings", []))
        # by-check breakdown
        rows = ""
        for chk, info in sorted((static.get("by_check") or {}).items(),
                                key=lambda kv: (SEV_ORDER.get(norm_sev(kv[1]["severity"]), 9),
                                                -kv[1]["count"])):
            rows += (f"<tr><td class='mono'>{esc(chk)}</td><td>{sev_badge(info['severity'])}</td>"
                     f"<td>{esc(info['count'])}</td></tr>")
        dups = static.get("cross_spec_duplicate_operation_ids") or {}
        dup_html = ""
        if dups:
            dl = "".join(f"<li><span class='mono'>{esc(k)}</span> &rarr; {esc('; '.join(v))}</li>"
                         for k, v in dups.items())
            dup_html = (f'<details class="dups"><summary>Cross-spec duplicate operationIds '
                        f'({len(dups)})</summary><ul>{dl}</ul></details>')
        parts.append(f"""
<section class="panel">
  <h2>Static documentation quality <span class="muted">&mdash; the spec analysed against 11 checks</span></h2>
  <p class="meta">modules <b>{esc(static.get("modules_analyzed",0))}</b>
     &middot; operations <b>{esc(static.get("operations_analyzed",0))}</b></p>
  {severity_bar(static.get("by_severity"))}
  <div class="split">
    <div class="by-check">
      <h3>By check</h3>
      <table><thead><tr><th>Check</th><th>Sev</th><th>Count</th></tr></thead>
      <tbody>{rows}</tbody></table>
      {dup_html}
    </div>
  </div>
  {filter_buttons("static")}
  <div class="tbl" data-scope="static">
    {findings_table(sf, [("severity","Sev"),("check","Check"),("method","Method"),
                         ("path","Path"),("detail","Detail")]) if sf
     else '<p class="muted">No static findings.</p>'}
  </div>
</section>
""")

    if not static and not drift:
        parts.append('<section class="panel"><p class="muted">No report files found. '
                     'Run the validators first.</p></section>')

    body = "\n".join(parts)
    return PAGE.replace("{{BODY}}", body)


PAGE = """<!DOCTYPE html>
<html lang="en"><head><meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>API Quality &amp; Documentation Validation</title>
<style>
  :root{ --bg:#0f1115; --panel:#171a21; --line:#262b36; --text:#e6e8ec; --muted:#8b8d98; }
  *{box-sizing:border-box}
  body{margin:0;background:var(--bg);color:var(--text);
       font:14px/1.5 -apple-system,BlinkMacSystemFont,"Segoe UI",Roboto,Helvetica,Arial,sans-serif}
  header{padding:28px 32px 8px}
  h1{margin:0;font-size:22px;font-weight:650}
  h2{font-size:16px;margin:0 0 4px} h3{font-size:13px;margin:0 0 8px;color:var(--muted)}
  .sub,.meta,.muted{color:var(--muted)} .sub{margin:4px 0 0}
  .mono{font-family:ui-monospace,SFMono-Regular,Menlo,monospace;font-size:12px}
  .cards{display:flex;gap:14px;flex-wrap:wrap;padding:14px 32px}
  .card{background:var(--panel);border:1px solid var(--line);border-radius:12px;
        padding:16px 20px;min-width:150px;flex:1}
  .card-val{font-size:28px;font-weight:700} .card-lbl{color:var(--muted);font-size:12px;margin-top:2px}
  .panel{background:var(--panel);border:1px solid var(--line);border-radius:12px;
         margin:14px 32px;padding:18px 20px}
  .bar{display:flex;height:14px;border-radius:7px;overflow:hidden;margin:10px 0 8px}
  .bar div{height:100%}
  .legend{display:flex;gap:16px;flex-wrap:wrap;font-size:12px;color:var(--muted)}
  .leg i{display:inline-block;width:10px;height:10px;border-radius:2px;margin-right:5px;vertical-align:middle}
  .badge{color:#0b0c0f;font-weight:700;font-size:11px;padding:2px 7px;border-radius:6px}
  table{width:100%;border-collapse:collapse;margin-top:10px}
  th,td{text-align:left;padding:7px 10px;border-bottom:1px solid var(--line);vertical-align:top}
  th{color:var(--muted);font-weight:600;font-size:12px;position:sticky;top:0;background:var(--panel)}
  td{font-size:12.5px}
  .tbl{max-height:520px;overflow:auto;border:1px solid var(--line);border-radius:10px;margin-top:8px}
  .filters{display:flex;gap:8px;margin-top:12px}
  .filt{background:transparent;color:var(--text);border:1px solid var(--line);
        border-radius:8px;padding:5px 12px;cursor:pointer;font-size:12px}
  .filt.active{background:var(--text);color:var(--bg);border-color:var(--text)}
  .split{display:flex;gap:24px;flex-wrap:wrap;margin-top:8px}
  .by-check{flex:1;min-width:260px}
  details.dups{margin-top:10px} summary{cursor:pointer;color:var(--muted)}
  footer{color:var(--muted);font-size:12px;padding:8px 32px 32px}
</style></head>
<body>
{{BODY}}
<footer>Generated by build_dashboard.py &middot; self-contained, no external assets.</footer>
<script>
document.querySelectorAll('.filters').forEach(function(group){
  var scope = group.getAttribute('data-scope');
  var tbl = document.querySelector('.tbl[data-scope="'+scope+'"]');
  group.querySelectorAll('.filt').forEach(function(btn){
    btn.addEventListener('click', function(){
      group.querySelectorAll('.filt').forEach(b=>b.classList.remove('active'));
      btn.classList.add('active');
      var f = btn.getAttribute('data-f');
      if(!tbl) return;
      tbl.querySelectorAll('tbody tr').forEach(function(tr){
        tr.style.display = (f==='ALL' || tr.getAttribute('data-sev')===f) ? '' : 'none';
      });
    });
  });
});
</script>
</body></html>
"""


def main():
    ap = argparse.ArgumentParser(description="Build a self-contained HTML dashboard from validator reports.")
    ap.add_argument("--static", default="static_report.json", help="Path to static_report.json")
    ap.add_argument("--drift", default="drift_report.json", help="Path to drift_report.json")
    ap.add_argument("--output", default="dashboard.html", help="Output HTML path")
    args = ap.parse_args()

    static = load(args.static)
    drift = load(args.drift)
    if static is None and drift is None:
        print(f"WARNING: neither {args.static} nor {args.drift} found; writing empty dashboard.")

    with open(args.output, "w") as fh:
        fh.write(build_html(static, drift))

    s = static.get("total_findings", 0) if static else "n/a"
    d = drift.get("total_findings", 0) if drift else "n/a"
    print(f"Wrote {args.output}  (static findings: {s}, drift findings: {d})")


if __name__ == "__main__":
    main()

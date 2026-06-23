#!/usr/bin/env python3
"""
send_drift_alerts.py
====================
Send detailed Slack alerts for HIGH severity API drift findings with document owner info.

Usage:
  python3 send_drift_alerts.py --webhook "https://hooks.slack.com/services/..." --drift-report drift_report.json

Environment variable:
  SLACK_WEBHOOK_URL  - Slack webhook URL (alternative to --webhook flag)
"""

import argparse
import json
import os
import sys
import urllib.request
import urllib.error
from datetime import datetime


# Document owners mapping (can be extended or loaded from a config file)
DOCUMENT_OWNERS = {
    "pipeline-service": "Pipeline Team",
    "ng-manager": "NG Manager Team",
    "template-service": "Template Team",
    "access-control": "Access Control Team",
    "ccm-apis": "CCM Team",
    "idp-service": "IDP Team",
    "release-management": "Release Team",
    "resilience-testing": "Resilience Team",
    "po-server": "PO Server Team",
    "sei": "SEI Team",
    "ssca-manager": "SSCA Team",
    "commons": "Commons Team"
}


def send_slack_message(webhook_url, message):
    """Send a message to Slack via webhook."""
    payload = json.dumps(message).encode('utf-8')
    req = urllib.request.Request(
        webhook_url,
        data=payload,
        headers={'Content-Type': 'application/json'}
    )

    try:
        with urllib.request.urlopen(req, timeout=10) as response:
            return response.status == 200, response.read().decode()
    except urllib.error.HTTPError as e:
        return False, f"HTTP {e.code}: {e.read().decode()}"
    except Exception as e:
        return False, str(e)


def get_alert_description(finding):
    """Generate a human-readable description for each alert type."""
    ftype = finding.get("type", "")
    method = finding.get("method", "")
    path = finding.get("path", "")
    status = finding.get("status", "")
    detail = finding.get("detail", "")

    descriptions = {
        "undocumented_status": {
            405: f"⚠️ **Method Not Allowed Issue**\n"
                 f"The endpoint `{method} {path}` is documented in the OpenAPI spec but the server returns `405 Method Not Allowed`.\n"
                 f"*Impact:* API consumers following the documentation will encounter errors.\n"
                 f"*Action Needed:* Either fix the server to support this method or remove it from the documentation.",

            500: f"💥 **Server Error on Documented Endpoint**\n"
                 f"The endpoint `{method} {path}` is returning `500 Internal Server Error`.\n"
                 f"*Impact:* This is a documented endpoint that is currently broken for API consumers.\n"
                 f"*Action Needed:* Investigate and fix the server error, or update documentation if this endpoint is deprecated.",

            "default": f"📋 **Undocumented Status Code**\n"
                       f"The endpoint `{method} {path}` returned status code `{status}` which is not documented in the OpenAPI spec.\n"
                       f"*Impact:* API consumers may not handle this response correctly.\n"
                       f"*Action Needed:* Add this status code to the OpenAPI documentation with proper response schema."
        }
    }

    if ftype == "undocumented_status":
        return descriptions[ftype].get(status, descriptions[ftype]["default"])

    return detail


def build_high_severity_alert(drift_report):
    """Build a detailed Slack message for HIGH severity drift findings."""
    module = drift_report.get("module", "unknown")
    findings = drift_report.get("findings", [])
    base_url = drift_report.get("base_url", "")
    ops_analyzed = drift_report.get("operations_analyzed", 0)

    # Filter HIGH severity only
    high_findings = [f for f in findings if f.get("severity", "").upper() == "HIGH"]

    if not high_findings:
        return None

    # Get document owner
    owner = DOCUMENT_OWNERS.get(module, "Unknown Team")

    # Build message blocks
    blocks = [
        {
            "type": "header",
            "text": {
                "type": "plain_text",
                "text": "🔴 HIGH Severity API Drift Alert"
            }
        },
        {
            "type": "section",
            "text": {
                "type": "mrkdwn",
                "text": f"*Module:* `{module}`\n*Document Owner:* {owner}\n*Base URL:* {base_url}\n*Operations Analyzed:* {ops_analyzed}"
            }
        },
        {
            "type": "divider"
        }
    ]

    # Add each HIGH severity finding as a separate section
    for i, finding in enumerate(high_findings, 1):
        operation_id = finding.get("operationId", "unknown")
        method = finding.get("method", "")
        path = finding.get("path", "")
        status = finding.get("status", "")
        documented_status = finding.get("documented", [])

        # Get detailed description
        description = get_alert_description(finding)

        # Build finding block
        finding_text = (
            f"*Finding #{i}: {operation_id}*\n\n"
            f"{description}\n\n"
            f"*Details:*\n"
            f"• Endpoint: `{method} {path}`\n"
            f"• Actual Status: `{status}`\n"
            f"• Documented Status: `{', '.join(map(str, documented_status))}`"
        )

        blocks.append({
            "type": "section",
            "text": {
                "type": "mrkdwn",
                "text": finding_text
            }
        })

        # Add divider between findings (but not after the last one)
        if i < len(high_findings):
            blocks.append({"type": "divider"})

    # Add footer
    blocks.append({
        "type": "context",
        "elements": [
            {
                "type": "mrkdwn",
                "text": f"🤖 API Drift Detector | {datetime.utcnow().strftime('%Y-%m-%d %H:%M UTC')} | *{len(high_findings)} HIGH severity issue(s) detected*"
            }
        ]
    })

    return {
        "text": f"🔴 HIGH Severity API Drift: {module} - {len(high_findings)} issue(s) - Owner: {owner}",
        "blocks": blocks
    }


def main():
    ap = argparse.ArgumentParser(description="Send detailed Slack alerts for HIGH severity API drift findings.")
    ap.add_argument("--webhook", default=os.getenv("SLACK_WEBHOOK_URL"),
                    help="Slack webhook URL (or set SLACK_WEBHOOK_URL env var)")
    ap.add_argument("--drift-report", default="drift_report.json",
                    help="Path to drift_report.json")
    args = ap.parse_args()

    if not args.webhook:
        sys.exit("ERROR: No webhook URL provided. Use --webhook or set SLACK_WEBHOOK_URL env var.")

    # Load drift report
    if not os.path.exists(args.drift_report):
        sys.exit(f"ERROR: Drift report not found: {args.drift_report}")

    with open(args.drift_report) as fh:
        drift_report = json.load(fh)

    # Build and send alert
    print(f"Analyzing drift report for module: {drift_report.get('module')}...")
    message = build_high_severity_alert(drift_report)

    if message is None:
        print("✅ No HIGH severity findings to report.")
        return 0

    high_count = len([f for f in drift_report.get("findings", []) if f.get("severity") == "HIGH"])
    print(f"Found {high_count} HIGH severity finding(s). Sending alert to Slack...")

    success, response = send_slack_message(args.webhook, message)

    if success:
        print("✅ Alert sent successfully!")
        print(f"   - Module: {drift_report.get('module')}")
        print(f"   - Owner: {DOCUMENT_OWNERS.get(drift_report.get('module'), 'Unknown Team')}")
        print(f"   - HIGH severity issues: {high_count}")
        return 0
    else:
        print(f"❌ Failed to send alert: {response}")
        return 1


if __name__ == "__main__":
    sys.exit(main())

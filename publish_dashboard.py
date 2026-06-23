#!/usr/bin/env python3
"""
publish_dashboard.py  --  push dashboard.html to a GitHub Pages branch.

Uploads an HTML file to a branch (default: gh-pages) of a GitHub repo using the
GitHub Contents API, so it becomes a clickable, downloadable page via GitHub Pages.
Pure standard library.

Env vars:
  GITHUB_TOKEN   GitHub PAT with 'Contents: write' (fine-grained) or 'repo' (classic). REQUIRED.
  GITHUB_REPO    owner/repo  (default: NaiveAbhay/harness-hackathon)
  GITHUB_BRANCH  target branch (default: gh-pages)

Usage:
  python publish_dashboard.py --file dashboard.html

If GITHUB_TOKEN is not set, the script prints a notice and exits 0 (does NOT fail
the build) so the pipeline still works before Pages is configured.
"""
import argparse
import base64
import json
import os
import sys
import urllib.error
import urllib.request

API = "https://api.github.com"


def gh(method, url, token, body=None):
    data = json.dumps(body).encode() if body is not None else None
    req = urllib.request.Request(url, data=data, method=method, headers={
        "Authorization": f"Bearer {token}",
        "Accept": "application/vnd.github+json",
        "X-GitHub-Api-Version": "2022-11-28",
        "User-Agent": "publish-dashboard",
    })
    try:
        with urllib.request.urlopen(req) as r:
            return r.status, json.loads(r.read() or "{}")
    except urllib.error.HTTPError as e:
        return e.code, json.loads(e.read() or "{}")


def ensure_branch(repo, branch, token):
    """Create `branch` from the repo's default branch head if it doesn't exist."""
    status, _ = gh("GET", f"{API}/repos/{repo}/git/ref/heads/{branch}", token)
    if status == 200:
        return
    # discover default branch + its head sha
    s, info = gh("GET", f"{API}/repos/{repo}", token)
    default = info.get("default_branch", "main")
    s, ref = gh("GET", f"{API}/repos/{repo}/git/ref/heads/{default}", token)
    sha = ref.get("object", {}).get("sha")
    if not sha:
        sys.exit(f"Could not read head of default branch '{default}': {ref}")
    s, res = gh("POST", f"{API}/repos/{repo}/git/refs", token,
                {"ref": f"refs/heads/{branch}", "sha": sha})
    print(f"Created branch '{branch}' from '{default}' (status {s}).")


def put_file(repo, branch, path, content_bytes, token):
    url = f"{API}/repos/{repo}/contents/{path}"
    # need existing file sha to update
    s, existing = gh("GET", f"{url}?ref={branch}", token)
    body = {
        "message": f"Publish {path} [skip ci]",
        "content": base64.b64encode(content_bytes).decode(),
        "branch": branch,
    }
    if s == 200 and isinstance(existing, dict) and existing.get("sha"):
        body["sha"] = existing["sha"]
    s, res = gh("PUT", url, token, body)
    if s not in (200, 201):
        sys.exit(f"Upload failed (status {s}): {res}")
    return res


def main():
    ap = argparse.ArgumentParser()
    ap.add_argument("--file", default="dashboard.html")
    ap.add_argument("--path", default=None, help="Path in the repo (default: same filename)")
    args = ap.parse_args()

    token = os.getenv("GITHUB_TOKEN")
    if not token:
        print("GITHUB_TOKEN not set -> skipping GitHub Pages publish. "
              "(Set the github_pat secret to enable a downloadable link.)")
        return  # exit 0: don't fail the build

    if not os.path.exists(args.file):
        print(f"{args.file} not found -> nothing to publish.")
        return

    repo = os.getenv("GITHUB_REPO", "NaiveAbhay/harness-hackathon")
    branch = os.getenv("GITHUB_BRANCH", "gh-pages")
    path = args.path or os.path.basename(args.file)

    with open(args.file, "rb") as fh:
        content = fh.read()

    ensure_branch(repo, branch, token)
    put_file(repo, branch, path, content, token)

    owner, name = repo.split("/", 1)
    pages_url = f"https://{owner.lower()}.github.io/{name}/{path}"
    print("=" * 60)
    print("DASHBOARD PUBLISHED")
    print(f"  Pages URL : {pages_url}")
    print(f"  (enable Pages once: repo Settings -> Pages -> branch '{branch}' / root)")
    print("=" * 60)


if __name__ == "__main__":
    main()

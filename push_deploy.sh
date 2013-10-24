#!/bin/sh

set -ex

cd dist/
git init || true
git remote add origin git@github.com:seance/ngtouch-deploy.git || true
git fetch origin
git reset --mixed origin/master
git add -A
git commit -m "Deployment update" --allow-empty
git push origin master
cd ..
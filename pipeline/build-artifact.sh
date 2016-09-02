#!/usr/bin/env bash
set -e

cd git-repo
mvn package
cp workshop-agenda-service/target/*.jar ../artifact-dir/

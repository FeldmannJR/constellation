#!/bin/bash

# A simple example script that publishes a number of scripts to the Nexus Repository Manager
# and executes them.

# fail if anything errors
set -e
# fail if a function call is missing an argument
set -u

username=admin
password=admin123

# add the context if you are not using the root context
host=http://nexus.minikube
# add a script to the repository manager and run it
function addAndRunScript {
  name=$1
  file=$2

  set -x
  # Delete
  curl -X DELETE -u $username:$password "$host/service/rest/v1/script/$name" -H  "accept: application/json"
  # Add
    http \
        -a "$username:$password" \
        --ignore-stdin \
        --check-status \
        POST $host/service/rest/v1/script \
        "name=$name" \
        type=groovy \
        "content=@$file"
  # Run
  curl -X POST -u $username:$password --header "Content-Type: text/plain" "$host/service/rest/v1/script/$name/run"
}

printf "Provisioning Integration API Scripts Starting \n\n"
printf "Publishing and executing on $host\n"

addAndRunScript repositories src/main/groovy/repositories.groovy

printf "\nProvisioning Scripts Completed\n\n"
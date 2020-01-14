#!/bin/bash
cwd=$(pwd)
cd ci
kubectl apply -k .
cd $cwd
kubectl patch serviceaccount default -p '{"imagePullSecrets": [{"name": "regcred"}]}'
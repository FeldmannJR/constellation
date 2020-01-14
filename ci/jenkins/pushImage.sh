#!/bin/bash
IMAGE_NAME=docker.nexus.minikube/constellation/jenkins-master
docker build . -t $IMAGE_NAME
docker push $IMAGE_NAME
#!/bin/bash
IMAGE_NAME=minikube:5000/constellation/jenkins-master
docker build . -t $IMAGE_NAME
docker push $IMAGE_NAME
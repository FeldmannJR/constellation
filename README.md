# Constellation
Learning Kubernetes with Minecraft Servers

## Why Minecraft Servers?
Since i was 14 years old, i have been developing [Spigot](https://www.spigotmc.org/), [BungeeCord](https://github.com/SpigotMC/BungeeCord) plugins, and consequently handling Linux based servers.  
In spigot plugins you have to create SQL queries,consume web apis, take care of server FPS, create a database structure, create proxies, and others.  
## The Problem
In a minecraft network you have multiple services depending in each other, and still you have to scale minecraft instances depending on the amount of players connected to the network, dealing with this manually or even with scripts is a pain in the ass, so i need to look for another solution.
## The Solution
Due to the complexity of a minecraft network, and the need for scalability, K8s is the perfect solution for this problem.  
So i want to combine the business with pleasure, and start to learning K8s to resolve this problem. My intend is to arquitect cluster to handle at the same time, Minecraft server instances, Web APIs, databases, caches, proxies, CI/CD, Repositories, and others.
## Want to help ?
Send a mail to feldmannjunior@gmail.com

## Configuration

In this project i'm using minikube because my object is to understand the concepts of K8s and after learn how to configure a cluster from scratch.

### DnsMasq
Since is much easy to remember domains rather than ips, i'm using dnsmasq to point all *.minikube domains to the minikube vm, and with this method is also much easier to setup ingresses. This was accomplished with adding this line in /etc/dnsmasq.conf.
```
# you can get your vm address with the command 'minikube ip'
address=/.minikube/192.168.39.54
```

### Minikube Addons
#### Ingress 
``minikube addons enable ingress``

#### Registry
``minikube addons enable registry``  
Before starting to deploying images to the registry, you need to allow unsecure registries in your machine.  
More information can be found [here](https://minikube.sigs.k8s.io/docs/tasks/docker_registry/).

## Components

### CI
```shell
# You can create the resources with
cd /ci
kubectl apply -k .
```
#### ci/jenkins/
I am using the jenkins kubernetes plugins, when a job is dispatched the plugin create automatically a pod to run it.   
The configuration is done through the Configuration as Code Plugin
#### ci/nexus/
Maven repository to store artifacts, the configuration is done automatically through groovy scripts.  
Using my own nexus3 image, that can be found [HERE](https://github.com/FeldmannJR/nexus3-docker-image).


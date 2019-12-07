# Learning Kubernetes with Minecraft Servers

## Why Minecraft Servers?
Since i was 14 years old, i have been developing [Spigot](https://www.spigotmc.org/), [BungeeCord](https://github.com/SpigotMC/BungeeCord) plugins, and consequently handling Linux based servers.  
In spigot plugins you have to create SQL queries,consume web apis, handle server FPS, create a database structure, create proxies, and others.  
## The Problem
In a minecraft network you have multiple services depending in each other, and still you have to scale minecraft instances depending on the amount of players connected to the network, dealing with this manually or even with scripts is a pain in the ass, so i need to look for another solution.
## The Solution
Due to the complexity of a minecraft network, and the need for scalability, K8s is the perfect solution for this problem.  
So i want to combine the business with pleasure, and start to learning K8s to resolve this problem. My intend is to arquitect cluster to handle at the same time, Minecraft server instances, Web APIs, databases, caches, proxies, CI/CD, Repositories, and others.
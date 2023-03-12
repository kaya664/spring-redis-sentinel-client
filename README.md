# spring-redis-sentinel-client
Demo for Spring Redis Sentinel Client

# Redis Installation
To install Redis, We can use kubernetes and docker, In this case Docker Desktop would be more than enough.
Link below can be used to understand how it works. https://bitnami.com/stack/redis/helm

Simply below steps will be enough

## This step will help to add bitnami helm repo to our local helm client
```shell 
  helm repo add bitnami https://charts.bitnami.com/bitnami
```
## This step will help us to run Redis in sentinel mode
```shell 
  helm install redis-sentinel --set auth.sentinel=true --set auth.password=myRedisPassword --set auth.enabled=true --set sentinel.enabled=true --set sentinel.masterSet=redis-sentinel-master bitnami/redis
```

| Property Name  | Value |
| ------------- | ------------- |
| auth.sentinel  | Lets us to create secured sentinel  |
| auth.password  | Lets us to define password |
| auth.enabled  | Lets us to create secured nodes |
| sentinel.enabled  | Lets us to install Redis in Sentinel mode |
| sentinel.masterSet  | Lets us to set name for Sentinel |

After running comman above, We must see pods running like in the below image
![image](https://user-images.githubusercontent.com/13851288/224551709-dd45b87b-6946-421a-957b-25137e4c2c9d.png)

# Spring Boot Application Running
To run Spring Boot app that we have in this repository in the same Kubernetes cluster with Redis Sentinel, We can follow steps below.

* Run mvn package for the app
* Run docker build -t spring-redis-sentinel-client:v2 .
* Go to kubernetes directory in the repository
* Run kubectl apply -f app.yaml
* Run kubectl apply -f service.yaml

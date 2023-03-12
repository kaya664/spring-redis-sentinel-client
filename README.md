# spring-redis-sentinel-client
Demo for Spring Redis Sentinel Client

# Redis Installation
To install Redis, We can use kubernetes and docker, In this case Docker Desktop would be more than enough.
Link below can be used to understand how it works. https://bitnami.com/stack/redis/helm

Simply below steps will be enough

##This step will help to add bitnami helm repo to our local helm client
```shell 
  helm repo add bitnami https://charts.bitnami.com/bitnami
```
##This step will help us to run Redis in sentinel mode
```shell 
  helm install redis-sentinel --set auth.sentinel=true --set auth.password=myRedisPassword --set auth.enabled=true --set sentinel.enabled=true --set sentinel.masterSet=redis-sentinel-master bitnami/redis
```

# Dubbo in Docker Example

Dubbo running in Docker, packaged as a springboot application.

## Services

This demo consistes three services:

- a zookeper instance
- a service producer
- a service consumer

The service producer exposes a ```Greeting``` service through RPC,
service consumer access the producer.

## Zookeeper

Run a docker image.

## Service Producer

Code in [service-producer](service-producer). API defined in [service-api](service-api).

Build docker image:

```
cd service-producer
mvn package
docker build -t producer .
```

## Service Consumer

Code in [service-consumer](service-consumer).

Build docker image:

```
cd service-consumer
mvn package
docker build -t consumer .
```

## Run

Use docker-compose command to run it.

```
cd docker
docker-compose up -d
```

Verify that all works:
```
$curl http://localhost:8899/
Greetings from Dubbo Docker
```

## Run it on Alibaba Cloud

Use [docker/docker-compose-acs.yml](docker/docker-compose-acs.yml) to deploy this application to
Aliyun Container Service (Alibaba Cloud) swarm cluster.

2017.11.30 Update:
Add compose v3 sample yml file: [docker/docker-compose-v3.yml](docker/docker-compose-v3.yml)



### Deploy the application to Kubernetes

2018.8.17 Update:

You can user helm to install this sample in a Kubernetes cluster. 

```
$ cd docker
$ helm install -n dubbo-sample dubbo-sample
```



Check helm status

```
$ helm list
NAME          REVISION	UPDATED                 	STATUS  	CHART                  	NAMESPACE
dubbo-sample  1       	Fri Aug 17 07:27:00 2018	DEPLOYED	dubbo-sample-0.0.1     	default
```



Check kubernetes and service status:

```
$ kubectl get po,svc
NAME                                              READY     STATUS    RESTARTS   AGE
pod/consumer-749bf8484d-js6wf                     1/1       Running   0          7m
pod/producer-b4f76b6c7-b8jhg                      1/1       Running   0          7m
pod/zookeeper-8455f4fdc9-ht9ms                    1/1       Running   0          7m

NAME                              TYPE        CLUSTER-IP      EXTERNAL-IP   PORT(S)    AGE
service/consumer                  ClusterIP   172.19.10.188   <none>        8899/TCP   7m
service/kubernetes                ClusterIP   172.19.0.1      <none>        443/TCP    45d
service/zookeeper                 ClusterIP   172.19.10.253   <none>        2181/TCP   7m
```



Expose consumer a public IP, or add ingress to it, Visit consumer via browser, you will see the greetings.

```
Greetings from Dubbo Docker
```



This sample tested on Aliyun Container Service for Kubernetes.
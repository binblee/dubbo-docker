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
Aliyun Container Service (Alibaba Cloud).
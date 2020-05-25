# spring-boot-with-docker

[![Codacy Badge](https://api.codacy.com/project/badge/Grade/e4b367754520420fa3c94cc88c9abb23)](https://app.codacy.com/manual/nishantrajput1212/spring-boot-with-docker?utm_source=github.com&utm_medium=referral&utm_content=nishant121212/spring-boot-with-docker&utm_campaign=Badge_Grade_Dashboard)

A users microservice to register and retrieve user. All the users created using this service will get stored in elasticsearch. This repo will demonstrate how to build docker image of Spring Boot microservice and connect it with other containers. Plus, I have created an elasticsearch repository using elasticsearch's high level REST client to POST and GET a user. All the services will run in separate docker containers but in same network say elk.

## Prerequisites
    Running Docker engine

### Build instructions
    mvn clean install

### Run instructions
    1. cd /path/to/project's/base/directory i.e. spring-boot-with-docker
    2. docker-compose up -d

### Standalone elastic and kibana containers
    [docker-setup-elastic-kibana](https://github.com/nishant121212/HW-tutorial-docker-setup-elastic-kibana)

### Kibana age count metric
![Kibana visualisation](kibana.png)

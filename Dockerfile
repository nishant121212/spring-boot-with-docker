FROM openjdk:8-jdk-alpine
MAINTAINER Nishant
WORKDIR /opt/
COPY target/users-docker-1.0.0-RELEASE.jar .
ENTRYPOINT ["java", "-jar", "users-docker-1.0.0-RELEASE.jar", "&"]
EXPOSE 9212

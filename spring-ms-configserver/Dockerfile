#
# Following: 
#	https://medium.com/@pramodshehan/simple-rest-api-with-springboot-postgres-and-docker-d15071908b8a
#	https://linuxize.com/post/how-to-build-docker-images-with-dockerfile/
#
FROM openjdk:8

#		/{company/domain}/{name}/{type}		| type=[api,app,webapp,batch]
WORKDIR /company/microservices/api

RUN mkdir ./config_repo

ADD target/spring-ms-configserver-0.0.1-SNAPSHOT.jar spring-ms-configserver-0.0.1-SNAPSHOT.jar

ENV GIT_URI="file://company/microservices/api/config_repo"

VOLUME /company/microservices/api/config_repo

EXPOSE 8888

ENTRYPOINT ["java", "-jar", "spring-ms-configserver-0.0.1-SNAPSHOT.jar"]
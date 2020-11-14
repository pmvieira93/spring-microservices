#
# Following: 
#	https://medium.com/@pramodshehan/simple-rest-api-with-springboot-postgres-and-docker-d15071908b8a
#	https://linuxize.com/post/how-to-build-docker-images-with-dockerfile/
#
FROM openjdk:8

#		/{company/domain}/{name}/{type}		| type=[api,app,webapp,batch]
WORKDIR /company/microservices/api

ADD target/spring-ms-zuulproxyserver-0.0.1-SNAPSHOT.jar spring-ms-zuulproxyserver-0.0.1-SNAPSHOT.jar

EXPOSE 8762

ENTRYPOINT ["java", "-jar", "spring-ms-zuulproxyserver-0.0.1-SNAPSHOT.jar"]
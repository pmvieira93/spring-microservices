# Maven: Compilation & Packaging

```
mvn clean install

mvn clean install package

mvn clean compile
```

# Java: Running By Command Line

```
java --% -Dserver.port=8084 -jar .\spring-ms-productcatalog-0.0.1-SNAPSHOT.jar
```

# Docker: Images & Containers

```
docker build -t ms-configserver:<latest> .

docker build -t ms-productcatalog:mobile .
docker run -d --name ms-product-catalog-mobile --net microservices \
	-e API_PORT=8084 \
	-p 8084:8084 \
	ms-productcatalog:mobile
	
docker build -t ms-discoveryserver .
docker run -d --name ms-discovery-server --net microservices \
	-p 8761:8761 \
	ms-discoveryserver:latest
```
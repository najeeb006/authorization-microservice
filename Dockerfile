FROM openjdk:17
EXPOSE 9090
COPY . .
ADD target/authorization-microservice-0.0.1-SNAPSHOT.jar authorization-microservice-latest
ENTRYPOINT ["java","-jar","/authorization-microservice-latest"]
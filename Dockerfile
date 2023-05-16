FROM maven:3.8.1-openjdk-17 AS build
MAINTAINER Abdullahi Isse "abdullahi12351@gmail.com"
WORKDIR /app
COPY pom.xml .
RUN mvn dependency:go-offline
COPY src/ /app/src/
RUN mvn clean test
RUN mvn package

FROM openjdk:17-jdk
WORKDIR /usr/local/bin/
COPY --from=build /app/target/Cinemania-0.0.1-SNAPSHOT.jar .
ENV db_url=jdbc:postgresql://cinemania.postgres.database.azure.com:5432/Cinemania
ENV db_username=Abdullahi@cinemania
ENV db_password=42323087Ab1
EXPOSE 80
ENTRYPOINT ["java","-jar","Cinemania-0.0.1-SNAPSHOT.jar"]


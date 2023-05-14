FROM ubuntu:latest
MAINTAINER Abdullahi Isse "abdullahi12351@gmail.com"
RUN apt-get update && apt-get install -y openjdk-17-jdk
RUN apt-get install -y maven
ENV db_url=jdbc:postgresql://cinemania.postgres.database.azure.com:5432/Cinemania
ENV db_username=Abdullahi@cinemania
ENV db_password=42323087Ab1
WORKDIR /usr/local/bin/
COPY . /usr/local/bin/
RUN mvn package
EXPOSE 80
ENTRYPOINT ["java","-jar","target/Cinemania-0.0.1-SNAPSHOT.jar"]


FROM openjdk:17-jdk
ENV db_url=jdbc:postgresql://cinemania.postgres.database.azure.com:5432/Cinemania
ENV db_username=Abdullahi@cinemania
ENV db_password=42323087Ab1
WORKDIR /usr/local/bin/
COPY target/Cinemania-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]
EXPOSE 80


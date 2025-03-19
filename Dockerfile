FROM openjdk:17
WORKDIR /app
COPY target/melkart-api-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT ["java", "-jar", "app.jar"]
EXPOSE 8080

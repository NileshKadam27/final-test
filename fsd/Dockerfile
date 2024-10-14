FROM eclipse-temurin:21-jdk-alpine
WORKDIR /app
COPY /target/fsd-0.0.1-SNAPSHOT.jar .
EXPOSE 8080
CMD ["java","-jar","-noverify","fsd-0.0.1-SNAPSHOT.jar"]
FROM openjdk:21-jdk
WORKDIR /app
ADD target/webapp-1.0.0.jar webapp-1.0.0.jar
ENTRYPOINT ["java","-Dspring.profiles.active=docker","-jar","webapp-1.0.0.jar"]
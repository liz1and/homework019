FROM openjdk:17-jdk-slim
RUN apt-get update && apt-get install -y git
COPY target/*.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]
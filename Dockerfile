FROM eclipse-temurin:17-jdk-jammy
#FROM openjdk:17-slim
#VOLUME /tmp
EXPOSE 80
ARG JAR_FILE=target/*.jar
ADD ${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar","/app.jar"]

#docker build -t InMemoryCacheApi:v1.0 .
#docker run --name InMemoryCacheApi -d -p 80:80 InMemoryCacheApi:v1.0
#docker run --name InMemoryCacheApi -d -p 80:80 -v /c/samplevolume:/test InMemoryCacheApi:v1.0



#
# Build stage
#
FROM maven:3.8.5-openjdk-21 AS build
COPY . .
#RUN mvn clean package -Pprod -DskipTests
RUN mvn clean package -DskipTests

#
# Package stage
#
FROM openjdk:21-jdk-slim
COPY --from=build /target/server-0.0.1-SNAPSHOT.jar server.jar
# ENV PORT=8080
EXPOSE 8080
ENTRYPOINT ["java","-jar","server.jar"]
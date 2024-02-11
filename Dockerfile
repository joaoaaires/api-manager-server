#
# Build stage
#
FROM maven:3.9.6-amazoncorretto-21 AS build
COPY . .
RUN mvn clean package -DskipTests

#
# Package stage
#
FROM amazoncorretto:21
COPY --from=build /target/api-manager-0.0.1-SNAPSHOT.jar server.jar
# ENV PORT=8080
EXPOSE 8080
ENTRYPOINT ["java","-jar","server.jar"]

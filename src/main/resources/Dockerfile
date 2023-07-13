Dockerfile FROM maven:3.8.3-openjdk-17 AS build
WORKDIR /app
COPY . /app/
RUN mvn clean package

FROM openjdk:17
COPY --from=build /app/target/*.jar /app/employeemanager-0.0.1-SNAPSHOT.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","employeemanager-0.0.1-SNAPSHOT.jar"]
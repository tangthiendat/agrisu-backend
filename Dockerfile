# Stage 1: Build the application
FROM maven:latest AS build

WORKDIR /app

COPY pom.xml .

RUN mvn dependency:go-offline

COPY src ./src

RUN mvn package -DskipTests

# Stage 2: Run the application
FROM eclipse-temurin:21.0.3_9-jre-jammy

WORKDIR /app

COPY --from=build /app/target/*.jar /app/app.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "/app/app.jar"]


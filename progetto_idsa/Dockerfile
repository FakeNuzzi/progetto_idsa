# Stage 1: Build with Maven
FROM maven:3.8.1-openjdk-17-slim AS build
WORKDIR /home/progetto_idsa/progetto_idsa
COPY pom.xml .
COPY src ./src
RUN mvn package -DskipTests
RUN ls target

# Stage 2: Run the application
FROM openjdk:17-slim
WORKDIR /app
COPY --from=build /home/progetto_idsa/progetto_idsa/target/my-app-1.0.jar ./my-app-1.0.jar
CMD ["java", "-jar", "my-app-1.0.jar"]
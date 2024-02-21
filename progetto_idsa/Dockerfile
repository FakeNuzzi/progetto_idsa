# Stage 1: Build with Maven
FROM maven:3.8.1-openjdk-17-slim AS build
WORKDIR /home/progetto_idsa/progetto_idsa
COPY pom.xml .
COPY src ./src
RUN mvn clean package -DskipTests
RUN ls target

# Stage 2: Run the application
FROM openjdk:17-slim
WORKDIR /app
EXPOSE 8080
COPY --from=build /home/progetto_idsa/progetto_idsa/target/backend-idsa.jar ./backend-idsa.jar
CMD ["java", "-jar", "backend-idsa.jar"]
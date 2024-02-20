FROM openjdk:11-jdk

# Update the package list and install maven
RUN apt-get update && apt-get install -y maven

WORKDIR /home/progetto_idsa/progetto_idsa

COPY pom.xml /home/progetto_idsa/progetto_idsa
COPY src /home/progetto_idsa/progetto_idsa/src

# compile the maven project skipping the tests
RUN mvn package -DskipTests

# replace this with your main class and any necessary arguments
CMD ["java", "-cp", "target/my-app-1.0.jar", "idsa.progetto_idsa.ProgettoIdsaApplication"]
FROM maven:3.8.2-openjdk-17 AS build

WORKDIR /app

# Copy the Maven project and build it
COPY pom.xml .
COPY src src/
RUN mvn package -DskipTests

FROM openjdk:17

WORKDIR /app

COPY --from=build /app/target/Spring-docker-Employee.jar ./

# Run the JAR file
ENTRYPOINT ["java", "-jar", "Spring-docker-Employee.jar"]
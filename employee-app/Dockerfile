FROM openjdk:17

WORKDIR /app

COPY target/Spring-docker-Employee.jar ./

# Expose the port your Spring Boot application runs on
# EXPOSE 8081

# Define environment variables for MySQL connection
# ENV SPRING_DATASOURCE_URL=jdbc:mysql://mysql:3306/yourdb
# ENV SPRING_DATASOURCE_USERNAME=root
# ENV SPRING_DATASOURCE_PASSWORD=yourpassword
# ENV SPRING_DATASOURCE_DRIVER-CLASS-NAME=com.mysql.cj.jdbc.Driver
# ENV SPRING_JPA_HIBERNATE_DDL-AUTO=update

# Run the JAR file
ENTRYPOINT ["java", "-jar", "Spring-docker-Employee.jar"]
# Stage 1: Build the application
FROM maven:3.8.5-openjdk-17 AS build

# Set the working directory inside the container
WORKDIR /app

# Copy the source code to the container
COPY . /app

# Build the project with Maven
RUN mvn clean package -DskipTests

# Stage 2: Create the final image
FROM openjdk:17-jdk-slim

# Copy the JAR file from the build stage to the final image
COPY --from=build /app/target/Ticket_booking_webApp-0.0.1-SNAPSHOT.jar Ticket_booking_webApp.jar

# Expose the application's port
EXPOSE 8080

# Command to run the application
ENTRYPOINT ["java", "-jar", "Ticket_booking_webApp.jar"]

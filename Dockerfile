# Start with a base image containing Java runtime (OpenJDK 17)
FROM openjdk:17-jdk-alpine

WORKDIR /app

COPY  ./target/*.jar /app/app.jar

# Make port 8080 available to the world outside this container
EXPOSE 8080

# Run the jar file
ENTRYPOINT ["java","-jar","app.jar"]

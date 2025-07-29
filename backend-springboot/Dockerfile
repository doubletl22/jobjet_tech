# Stage 1: Build the application
FROM gradle:8.5.0-jdk17 AS build
WORKDIR /home/gradle/src
COPY --chown=gradle:gradle . .
RUN gradle build --no-daemon

# Stage 2: Create the final image
FROM openjdk:17-jdk-slim
WORKDIR /app
COPY --from=build /home/gradle/src/build/libs/*.jar app.jar
ENTRYPOINT ["java", "-jar", "app.jar"]
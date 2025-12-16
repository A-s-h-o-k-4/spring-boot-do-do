# Use a valid Maven + JDK image
FROM maven:3.9.3-eclipse-temurin-17

WORKDIR /app
COPY pom.xml .
COPY src ./src

# Build the app
RUN mvn clean package -DskipTests

# Use JDK runtime to run Spring Boot
FROM eclipse-temurin:17-jdk
WORKDIR /app
COPY --from=0 /app/target/*.jar app.jar

EXPOSE 8080
ENTRYPOINT ["java","-jar","app.jar"]

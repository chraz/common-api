FROM openjdk:17-slim
COPY backend-api/target/*.jar /home/app/backend-api-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java", "-jar", "/home/app/backend-api-0.0.1-SNAPSHOT.jar"]

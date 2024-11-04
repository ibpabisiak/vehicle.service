FROM openjdk:23-jdk-slim
EXPOSE 8080
ENV JAVA_OPTS="-XX:+UseContainerSupport"
ARG JAR_FILE="build/libs/vehicle.service-0.0.1-SNAPSHOT.jar"
ADD ${JAR_FILE} app.jar
ENTRYPOINT ["sh", "-c", "java $JAVA_OPTS -jar /app.jar"]

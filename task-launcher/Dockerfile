FROM openjdk:8-jre-alpine
MAINTAINER Ali Shahbour <shahbour@gmail.com>

VOLUME /tmp
ARG JAR_FILE
ADD ${JAR_FILE} /app/task-launcher.jar
CMD ["java", "-Xmx512m", "-jar", "/app/task-launcher.jar"]

FROM openjdk:8-jre-alpine
MAINTAINER Ali Shahbour <shahbour@gmail.com>

VOLUME /tmp
ARG JAR_FILE
ADD ${JAR_FILE} /app/app.jar
CMD ["java", "-Xmx512m", "-jar", "/app/app.jar"]

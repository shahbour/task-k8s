FROM openjdk:8-jre-alpine
MAINTAINER Ali Shahbour <shahbour@gmail.com>
RUN apk update && apk add curl && rm -rf /var/cache/apk
VOLUME /tmp
ARG JAR_FILE
ADD ${JAR_FILE} /app/app.jar
CMD ["java", "-Xmx512m", "-jar", "/app/app.jar"]

FROM openjdk:8-jdk-alpine
LABEL maintainer="markus@helmes.com"
RUN mkdir /app
WORKDIR /app
ADD build/libs/swagger-ui-0.1.0.jar /app/app.jar
CMD java -Dspring.config.location=classpath:/application.yml,file:/app/application.yml -jar /app/app.jar
EXPOSE 8888

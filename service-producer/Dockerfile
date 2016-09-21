FROM openjdk:8-jre
VOLUME /tmp
COPY target/*.jar /app.jar
RUN sh -c 'touch /app.jar'
CMD ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]
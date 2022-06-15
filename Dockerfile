FROM openjdk

WORKDIR /app
COPY ./target/Mp3Reader-0.0.1-SNAPSHOT.jar /app

EXPOSE 8080

CMD ["java", "-jar", "Mp3Reader-0.0.1-SNAPSHOT.jar"]
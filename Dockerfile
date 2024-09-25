FROM openjdk:17-jdk

ENV JAR_FILE=target/CrudSpringApp-0.0.1-SNAPSHOT.jar

COPY ${JAR_FILE} app.jar

ENTRYPOINT ["java", "-jar", "/app.jar"]

EXPOSE 8080

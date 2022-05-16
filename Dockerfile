FROM openjdk
ARG JAR_FILE=target/MavenSpring-0.0.1-SNAPSHOT.jar
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar","/app.jar"]
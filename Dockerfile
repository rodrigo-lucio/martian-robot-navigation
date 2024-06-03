FROM openjdk:17-alpine
COPY target/martian-robot-navigation-0.0.1-SNAPSHOT.jar /app/martian-robot-navigation.jar
WORKDIR /app
ENTRYPOINT ["java", "-jar", "martian-robot-navigation.jar"]

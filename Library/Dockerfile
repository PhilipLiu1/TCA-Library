FROM openjdk:8-windowsservercore

LABEL maintainer="congshil@yahoo.ca"

COPY target/Library-0.0.1-SNAPSHOT.jar /TCA.jar
EXPOSE 8080

CMD ["java", "-jar", "TCA.jar"]
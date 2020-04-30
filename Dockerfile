FROM openjdk:14-alpine
COPY target/complete-*.jar complete.jar
EXPOSE 8080
CMD ["java", "-Dcom.sun.management.jmxremote", "-Xmx128m", "-jar", "complete.jar"]

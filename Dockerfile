FROM openjdk:17
EXPOSE 8080
ENTRYPOINT [ "java", "-jar", "softhouse-1.0-all.jar" ]
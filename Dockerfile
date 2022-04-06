FROM openjdk:17
EXPOSE 8080
COPY ./build/libs/softhouse-1.0-all.jar .
ENTRYPOINT [ "java", "-jar", "softhouse-1.0-all.jar" ]
FROM openjdk:17 
COPY ./build/libs/softhouse-1.0-all.jar .
EXPOSE 8080
ENTRYPOINT [ "java", "-jar", "softhouse-1.0-all.jar" ]
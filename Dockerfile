FROM openjdk:17
ENTRYPOINT [ 'bash', '-c', './gradlew', 'assemble' ]

FROM openjdk:17 
COPY --from=0 ./build/libs/softhouse-1.0-all.jar .
EXPOSE 8080
ENTRYPOINT [ "java", "-jar", "softhouse-1.0-all.jar" ]
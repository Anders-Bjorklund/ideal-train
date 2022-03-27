FROM openjdk:17 AS compile_step
ENTRYPOINT [ 'bash', '-c', './gradlew', 'assemble' ]

FROM openjdk:17
ARG JAR_FILE
COPY ${JAR_FILE} softhouse-1.0-all.jar
EXPOSE 8080
ENTRYPOINT [ "java", "-jar", "softhouse-1.0-all.jar" ]
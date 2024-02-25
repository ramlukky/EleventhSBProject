FROM openjdk:11
EXPOSE 8080
COPY target/EleventhSBProject.jar EleventhSBProject.jar
ENTRYPOINT ["java","-jar","/EleventhSBProject.jar"]
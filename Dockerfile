FROM java:11
EXPOSE 8080
ADD /target/chat-0.0.1-SNAPSHOT.jar chat.jar
ENTRYPOINT ["java","-jar","chat.jar"]
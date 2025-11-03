# below line define which jdk we want to use.
FROM openjdk:8-jdk
# below line will add our jar file into image folder as app.jar
ADD target/*.jar app.jar
# below line define how we want to run our application
ENTRYPOINT ["java", "-jar","app.jar"]

EXPOSE 8181
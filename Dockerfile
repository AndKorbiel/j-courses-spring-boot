FROM openjdk:26-ea-oraclelinux8
WORKDIR /src
COPY target/*.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]
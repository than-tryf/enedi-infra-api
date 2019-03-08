FROM openjdk:8

COPY ./target/infrastructure-1.0-SNAPSHOT.jar /home/infrastructure-1.0-SNAPSHOT.jar

CMD ["java","-jar", "/home/infrastructure-1.0-SNAPSHOT.jar"]

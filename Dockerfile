FROM maven:3.8.5-openjdk-17 AS build
COPY . .
RUN mvn clean package -DskipTests

FROM openjdk:17.0.1-jdk-slim
COPY --from=build /target/personal_trainer-0.0.1-SNAPSHOT.jar personal_trainer.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","personal_trainer.jar"]


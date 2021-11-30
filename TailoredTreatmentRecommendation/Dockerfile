FROM openjdk:8-jdk-alpine

RUN addgroup -S spring && adduser -S spring -G spring

USER spring:spring

VOLUME /tmp

WORKDIR .

ARG JAR_FILE=/target/TailoredTreatmentRecommendation-0.0.1-SNAPSHOT.jar

COPY ${JAR_FILE} TailoredTreatmentRecommendation-0.0.1-SNAPSHOT.jar

ADD  drug-disease-mapping.csv ./drug-disease-mapping.csv

EXPOSE 8088

ENTRYPOINT ["java","-jar","/TailoredTreatmentRecommendation-0.0.1-SNAPSHOT.jar"]
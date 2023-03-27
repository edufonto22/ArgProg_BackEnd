FROM amazoncorretto:8
MAINTAINER EPF
COPY target/EPF-0.0.1-SNAPSHOT.jar EPF-app.jar
ENTRYPOINT ["java","-jar","/EPF-app.jar"]

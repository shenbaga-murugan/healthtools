FROM java:8-jdk-alpine
COPY ./target/health-tools-*.jar /usr/app/health-tools.jar
WORKDIR /usr/app
ENTRYPOINT ["java","-jar","health-tools.jar"]
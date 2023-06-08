FROM maven:3.6.3-jdk-11

ENV CLIENT_ID="611616605716-7vi7b8t378nmtknrism7tglk94bkf3a6.apps.googleusercontent.com"

ENV CLIENT_SECRET="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"

COPY . .

EXPOSE 8080

RUN mvn package

CMD ["java", "-jar", "/target/employeeV11-0.0.1-SNAPSHOT.jar"]
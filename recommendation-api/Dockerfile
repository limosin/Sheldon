FROM --platform=linux/amd64 maven:3.9.3 AS maven

WORKDIR /usr/src/app
COPY . /usr/src/app
RUN mvn clean package -DskipTests

# For Java 11,

FROM --platform=linux/amd64 amazoncorretto:17


ARG JAR_FILE=target/*.jar

WORKDIR /opt/app

COPY --from=maven /usr/src/app/${JAR_FILE} /opt/app/app.jar

EXPOSE 80

ENTRYPOINT ["java", "-jar","app.jar"]
FROM openjdk:21
RUN mkdir /app
WORKDIR /app

ADD ./build/libs/product-0.0.1-SNAPSHOT.jar /app/app.jar

EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]
FROM openjdk:21
RUN mkdir /app
WORKDIR /app

COPY ./build/libs/product-0.0.1-SNAPSHOT.jar product-0.0.1-SNAPSHOT.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "product-0.0.1-SNAPSHOT.jar"]
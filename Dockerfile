FROM eclipse-temurin:17-jdk-alpine
RUN mkdir /app
WORKDIR /app

COPY /product-0.0.1-SNAPSHOT.jar product-0.0.1-SNAPSHOT.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "product-0.0.1-SNAPSHOT.jar"]
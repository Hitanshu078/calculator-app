FROM eclipse-temurin:25-jre

WORKDIR /app

COPY target/calculator-app-1.0.jar app.jar

CMD ["java", "-jar", "app.jar"]

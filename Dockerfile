FROM openjdk:21-jdk

WORKDIR /app

CMD ["pwd"]
COPY build/libs/springboot-inaction.jar app.jar

EXPOSE 8080

ENTRYPOINT ["java", "-Xms512m", "-Xmx1024m", "-XX:+UseG1GC", "-jar", "app.jar"]
FROM openjdk:21-jdk

COPY target/demo-config-watcher-service.jar app.jar

ENTRYPOINT ["java", "-jar", "-Dspring.config.location=/etc/config/application.yml", "/app.jar", "--spring.profiles.active=${SPRING_PROFILES_ACTIVE}"]

EXPOSE 8080
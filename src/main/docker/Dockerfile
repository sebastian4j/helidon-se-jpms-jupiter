FROM bitnami/minideb:latest
EXPOSE 8080
RUN mkdir /app
COPY ${project.artifactId}.jar /app
COPY libs /app/libs
COPY jre /jre
CMD ["/jre/bin/java", "-jar", "/app/${project.artifactId}.jar"]

FROM azul/zulu-openjdk:17-latest

WORKDIR /app
COPY build/libs/music_adjaf_mf3-0.0.1.jar app.jar
EXPOSE 8080
CMD ["java", "-jar", "app.jar"]
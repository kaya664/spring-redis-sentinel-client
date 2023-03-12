FROM openjdk:17
RUN mkdir /code
ADD ./target/redis-client-0.0.1-SNAPSHOT.jar /code
WORKDIR /code
EXPOSE 8080
CMD ["java", "-jar", "redis-client-0.0.1-SNAPSHOT.jar"]

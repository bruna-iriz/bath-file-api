FROM openjdk:11
WORKDIR /app
VOLUME /tmp

COPY ./target/conversations-batch-api*.jar api-batch.jar
# COPY wait-for-it.sh /wait-for-it.sh
EXPOSE 8080
EXPOSE 5005
EXPOSE 3306
CMD ["java", "-jar", "api-batch.jar"]
FROM maven:3.6-jdk-8 as builder
# Bulding the bungeecord plugin
WORKDIR /usr/src/app
COPY . .
RUN mvn clean package
# -----------------------------------
FROM openjdk:8-alpine

ENV BUNGEECORD_BUILD=1425
WORKDIR /server/
# Installing packages
RUN apk add tzdata bash tmux
# Setting the timezone for Sao Paulo
ENV TZ="America/Sao_Paulo"
# Min ram percentage for java heap
ENV JAVA_MIN_PERCENTAGE="80.0"
# Max ram percange for java heap
ENV JAVA_MAX_PERCENTAGE="80.0"
# Coping application
COPY --from=builder /usr/src/app/target/*.jar .
COPY .docker/server .
ADD https://ci.md-5.net/job/BungeeCord/${BUNGEECORD_BUILD}/artifact/bootstrap/target/BungeeCord.jar .
COPY .docker/entrypoint.sh /entrypoint.sh
ENTRYPOINT ["/entrypoint.sh"]
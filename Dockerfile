FROM artifactory.cardlay.com:5001/frolvlad/alpine-oraclejdk8:slim
RUN apk update && apk add --no-cache curl
ADD target/leak-0.0.1-SNAPSHOT.jar /opt/leak.jar
ADD src/main/resources/docker-entrypoint.sh /opt/docker-entrypoint.sh
CMD /opt/docker-entrypoint.sh
EXPOSE 8080

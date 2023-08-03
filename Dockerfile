# Imagem base para build
FROM maven:3.8.5-openjdk-11-slim AS build

RUN mkdir -p /build
WORKDIR /build

COPY pom.xml /build
COPY src /build/src

RUN mvn -f pom.xml clean package -B

# Imagem base para implantação
FROM openjdk:11.0.11-jre-slim
COPY --from=build /build/target/*.jar app.jar

EXPOSE 8080
ENTRYPOINT ["java","-jar","app.jar"]

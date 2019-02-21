FROM maven:latest as maven-build
WORKDIR /build
COPY . .
RUN mvn clean package
FROM java:8
WORKDIR /opt/website
EXPOSE 8088
COPY --from=maven-build /build/target/ApartmentManager-VerifyAccount-0.0.1-SNAPSHOT.jar verify.jar
ENTRYPOINT ["java", "-jar", "verify.jar"]	

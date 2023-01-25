FROM maven

WORKDIR /springboot-pets-project
COPY . .
RUN mvn clean install

CMD mvn spring-boot:run
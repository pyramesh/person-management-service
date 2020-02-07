The tasks that are completed are below
1. Implemented REST API for CRUD operations on person entity
2. Secured API with JWT authentication
3. Application can be tested with Swagger API Documentation without installing any software.

Technologies uses in this project

1. Java 8
2. Spring Boot
3. REST API
4. JPA
5. Spring JPA data repositories
6. SWagger API Documentation
7. JWT for Authentication

Database
------------
H2 in-memory database
http://localhost:8080/h2-console

spring.datasource.url=jdbc:h2:mem:testdb
spring.datasource.driverClassName=org.h2.Driver
spring.datasource.username=sa
spring.datasource.password=

The application starts with port 8080

to verify the application use Swagger API URL

    http://localhost:8080/swagger-ui.html#/person-controller

Since REST enpoints are implemented with JWT Authentication security, In order to test JWT token has to be given first.
If the token is authenticated successfully, REST endpoints can be tested.

Please refer "person_service_guide.docx" to get instructions how to build and run the application with screen shots.




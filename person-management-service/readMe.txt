Technologies uses in this project

1. Spring Boot
2. REST API
3. JPA
4. Spring JPA data repositories
5. SWagger API Documentation
6. JWT for Authentication

Database
------------
H2 in-memory database

The application starts with port 8080

to verify the application use Swagger API URL

    http://localhost:8080/swagger-ui.html#/person-controller

Since REST enpoints are implemented with JWT Authentication security, In order to test JWT token has to be given first.
If the token is authenticated successfully, REST endpoints can be tested.




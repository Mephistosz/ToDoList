<h1 align="center">
  TODO List
</h1>

This is an API for managing tasks (CRUD) that is part of [this challenge](https://github.com/simplify-liferay/desafio-junior-backend-simplify) for junior backend developers applying to Simplify.

## Technologies
 
- [Spring Boot](https://spring.io/projects/spring-boot)
- [Spring MVC](https://docs.spring.io/spring-framework/reference/web/webmvc.html)
- [Spring Data JPA](https://spring.io/projects/spring-data-jpa)
- [SpringDoc OpenAPI 3](https://springdoc.org/v2/#spring-webflux-support)
- [Mysql](https://dev.mysql.com/downloads/)

## Adopted Practices

- SOLID, DRY, YAGNI, KISS
- API REST
- Spring Data JPA queries for efficient data retrieval
- Dependency Injection for loose coupling and modular design
- Error response handling to ensure graceful error management
- Automated Swagger generation using OpenAPI 3 for API documentation

## How to Run

- Clone the Git repository
- Build the project:
```
$ ./mvnw clean package
```
- Run the application:
```
$ java -jar target/todolist-0.0.1-SNAPSHOT.jar
```

The API can be accessed at [localhost:8080](http://localhost:8080).
You can view the Swagger documentation by visiting [localhost:8080/swagger-ui.html](http://localhost:8080/swagger-ui.html).

## API Endpoints

For the HTTP requests below, the tool used was [postman](https://www.postman.com):

- create Task
```
curl --location --request POST 'http://localhost:8080/tasks' --header 'Content-Type: application/json' --data '{ 
    "name": "1teste",
    "description": "test2description",
    "status": "BACKLOG",
    "priority": "HIGH"
}'
```

- List Tasks
```
curl --location --request GET 'http://localhost:8080/tasks'
```

- Update Task
```
curl --location --request PUT 'http://localhost:8080/tasks/74' --header 'Content-Type: application/json' --data '{
    "name": "test3Name",
    "description": "test3description",
    "status": "BACKLOG",
    "priority": "LOW"
}'
```

- Delete Task
```
curl --location --request DELETE 'http://localhost:8080/tasks/74' --header 'Content-Type: application/json'
```

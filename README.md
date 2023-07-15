<h1 align="center">
  TODO List
</h1>

API para gerenciar tarefas (CRUD) que faz parte [desse desafio](https://github.com/simplify-liferay/desafio-junior-backend-simplify) para pessoas desenvolvedoras backend júnior, que se candidatam para a Simplify.

## Tecnologias
 
- [Spring Boot](https://spring.io/projects/spring-boot)
- [Spring MVC](https://docs.spring.io/spring-framework/reference/web/webmvc.html)
- [Spring Data JPA](https://spring.io/projects/spring-data-jpa)
- [SpringDoc OpenAPI 3](https://springdoc.org/v2/#spring-webflux-support)
- [Mysql](https://dev.mysql.com/downloads/)

## Práticas adotadas

- SOLID, DRY, YAGNI, KISS
- API REST
- Consultas com Spring Data JPA
- Injeção de Dependências
- Tratamento de respostas de erro
- Geração automática do Swagger com a OpenAPI 3

## Como Executar

- Clonar repositório git
- Construir o projeto:
```
$ ./mvnw clean package
```
- Executar a aplicação:
```
$ java -jar target/todolist-0.0.1-SNAPSHOT.jar
```

A API poderá ser acessada em [localhost:8080](http://localhost:8080).
O Swagger poderá ser visualizado em [localhost:8080/swagger-ui.html](http://localhost:8080/swagger-ui.html)

## API Endpoints

Para fazer as requisições HTTP abaixo, foi utilizada a ferramenta [postman](https://www.postman.com):

- Criar Tarefa 
```
curl --location --request POST 'http://localhost:8080/tasks' --header 'Content-Type: application/json' --data '{ 
    "name": "1teste",
    "description": "test2description",
    "status": "BACKLOG",
    "priority": "HIGH"
}'
```

- Listar Tarefas
```
curl --location --request GET 'http://localhost:8080/tasks'
```

- Atualizar Tarefa
```
curl --location --request PUT 'http://localhost:8080/tasks/74' --header 'Content-Type: application/json' --data '{
    "name": "test3Name",
    "description": "test3description",
    "status": "BACKLOG",
    "priority": "LOW"
}'
```

- Remover Tarefa
```
curl --location --request DELETE 'http://localhost:8080/tasks/74' --header 'Content-Type: application/json'
```
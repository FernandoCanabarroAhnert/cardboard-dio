# Projeto Back-end: Board de Tarefas da DIO

![Java](https://img.shields.io/badge/java-FF5722.svg?style=for-the-badge&logo=openjdk&logoColor=white)
![Spring Boot](https://img.shields.io/badge/Spring%20Boot-6DB33F?style=for-the-badge&logo=spring-boot&logoColor=white)
![Hibernate](https://img.shields.io/badge/Hibernate-F57F17?style=for-the-badge&logo=Hibernate&logoColor=white)
![MySQL](https://img.shields.io/badge/mysql-4479A1.svg?style=for-the-badge&logo=mysql&logoColor=white)
![PhpMyAdmin](https://img.shields.io/badge/PhpMyAdmin-6f42c1?style=for-the-badge&logo=phpmyadmin&logoColor=white)
![Docker](https://img.shields.io/badge/Docker-2496ED?style=for-the-badge&logo=docker&logoColor=white)
![Flyway](https://img.shields.io/badge/Flyway-CC0202?style=for-the-badge&logo=flyway&logoColor=white)

## Modelo de Domínio
![DiagramaClasses](https://github.com/user-attachments/assets/51e66156-0965-4847-b5be-84faf6fa00b1)

## O que é o projeto? 🤔

Este é um projeto de gerenciamento de Board de Tarefas, que permite criar, visualizar e deletar um Board, criar, visualizar e mover uma tarefa, bem como visualizar uma Coluna do Board por id. Foram utilizadas as tecnologias Java, Spring Boot, Docker, MySQL, PhpMyAdmin e Flyway. Para a documentação, foi utilizado o Swagger.

## Tecnologias 💻
 
- [Spring Boot](https://spring.io/projects/spring-boot)
- [Spring Data JPA](https://spring.io/projects/spring-data-jpa)
- [MySQL](https://www.mysql.com/)
- [PhpMyAdmin](https://www.phpmyadmin.net/)
- [Docker](https://www.docker.com/)
- [Bean Validation](https://docs.spring.io/spring-framework/reference/core/validation/beanvalidation.html)
- [Flyway](https://www.red-gate.com/products/flyway/community/)

## Tela do Swagger
![Swagger](https://github.com/user-attachments/assets/759bc7b0-c66a-408c-b528-6d6d33da9fd9)

## Como executar 🎉

1.Clonar repositório git:

```text
git clone https://github.com/FernandoCanabarroAhnert/cardboard-dio
```

2.Instalar dependências.

```text
mvn clean install
```

3.Executar a aplicação Spring Boot.

4.Testar endpoints através do Postman ou da url
<http://localhost:8080/swagger-ui/index.html>

### Usando Docker 🐳

- Clonar repositório git
- Construir o projeto:
```
./mvnw clean package
```
- Construir a imagem:
```
./mvnw spring-boot:build-image
```
- Executar o container:
```
docker run --name cardboard-dio -p 8080:8080  -d cardboard-dio:0.0.1-SNAPSHOT
```
## API Endpoints 📚

Para fazer as requisições HTTP, foi utilizada a ferramenta [Postman](https://www.postman.com/):
- Collection do Postman completa: [PostmanCollection](https://github.com/user-attachments/files/22011992/Boardcard.API.postman_collection.json)
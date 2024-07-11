# Projeto SpringBoot E-commerce
![Java](https://img.shields.io/badge/java-%23ED8B00.svg?style=for-the-badge&logo=openjdk&logoColor=white)
![Spring](https://img.shields.io/badge/spring-%236DB33F.svg?style=for-the-badge&logo=spring&logoColor=white)
![Udemy](https://img.shields.io/badge/Udemy-A435F0?style=for-the-badge&logo=Udemy&logoColor=white)

Esse projeto representa a uma simples estrutura de um sistema de em-commerce. Ele foi contruído utilizando Java, Java Spring, Spring JPA, Spring Hateoas, Postman para testar as requisições e o H2database como banco de dados em memória para teste.

Esse sistema foi desenvolvido pelo professor Nelio Alves do curso de Java Completo oferecido pela plataforma de Udemy.
Ele tem o objetivo de testar os conhecimentos aprendidos durante o desenvolvimento do curso.

## Instalação
1. Clone o repositório: 
```bash
git clone http://github.com/mclara831/project-springboot-jpa
```
2. Instale as dependências do Maven.

## Utilização 
1. Inicie a aplicação.
2. As API's podem ser acessadas em http://localhost:8080

## Modelo de domínio
![modelo de domínio](modelo_de_domínio.png)

## EndPoints

### Users
```bash
GET /users - retornar todos os usuários registrados.

POST /users/save - registra um novo usuário.

UPDATE /users/{id} - atualiza os dados do usuario fornecido pelo id.

DELETE /users/{id} - deleta o usuário.
```
### Orders
```bash
GET /users - retornar todos os pedidos registrados.

GET /users/{id} - retornar o pedido fornecido pelo id.
```

### Produtos
```bash
GET /users - retornar todos os produtos registrados.

GET /users/{id} - retornar o produto fornecido pelo id.
```

### Categorias
```bash
GET /users - retornar todas as categorias registradas.

GET /users/{id} - retornar a categoria fornecida pelo id.
```

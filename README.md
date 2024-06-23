# Projeto de API REST com Spring Boot e MongoDB

Este projeto é uma API RESTful desenvolvida em Java com o framework Spring Boot e utiliza MongoDB como banco de dados. A API oferece operações básicas de CRUD (Create, Read, Update, Delete) para gerenciar recursos relacionados a usuários.

## Funcionalidades Principais

- **Cadastro de Usuários:** Permite criar novos usuários com informações básicas.
- **Consulta de Usuários:** Retorna informações de usuários existentes.
- **Atualização de Usuários:** Permite modificar dados de usuários já cadastrados.
- **Remoção de Usuários:** Permite excluir usuários do sistema.

## Tecnologias Utilizadas

- Java
- Spring Boot
- MongoDB

## Estrutura do Projeto

O projeto segue uma estrutura padrão de aplicação Spring Boot, organizado em:

- `controllers`: Controladores que definem as rotas da API.
- `models`: Modelos de dados que representam entidades do sistema.
- `repositories`: Interfaces que definem operações de acesso ao banco de dados.

## Como Usar

A API expõe endpoints HTTP para interação, disponíveis em `http://localhost:8080/api/users`:

- `GET /api/users`: Retorna todos os usuários cadastrados.
- `GET /api/users/{id}`: Retorna um usuário específico pelo ID.
- `POST /api/users`: Cria um novo usuário com os dados fornecidos.
- `PUT /api/users/{id}`: Atualiza os dados de um usuário existente pelo ID.
- `DELETE /api/users/{id}`: Remove um usuário pelo ID especificado.

Consulte a documentação da API ou os arquivos de controle para detalhes adicionais sobre cada endpoint.

## Finalidade

Este projeto serve como exemplo básico de uma API REST utilizando Spring Boot e MongoDB, adequado para demonstrar conceitos de desenvolvimento de backend em Java.


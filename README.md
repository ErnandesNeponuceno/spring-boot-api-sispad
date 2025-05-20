# 🥐 API de Gestão de Usuários - Padaria Sispad

Este projeto é uma API REST desenvolvida em **Java** com **Spring Boot**, voltada para o gerenciamento de **usuários** no sistema de uma padaria. Utilizando MySQL como banco de dados, a aplicação fornece funcionalidades completas de CRUD (Create, Read, Update, Delete), além de validações e tratamento de exceções.

---

## 🛠️ Funcionalidades

- **Usuários**
  - Listar todos os usuários.
  - Listar um usuário por ID.
  - Adicionar um novo usuário.
  - Atualizar os dados de um usuário existente.
  - Deletar um usuário.
  - Validação de duplicidade de nome.

- **Validações**
  - Nome e status obrigatórios.
  - Verificação de nomes repetidos no momento da criação e atualização.

- **Tratamento de Erros**
  - Erros de validação (400).
  - Entidades não encontradas (404).
  - Erros internos do servidor (500).

---

## 🎯 Estrutura do Projeto

### **Pacotes principais**
```plaintext
com.sistema.sispad
├── controller        # Controladores REST
├── dto              # Objetos de transferência de dados
├── exceptions        # Exceções personalizadas
├── model             # Entidades JPA
├── repository        # Interfaces JPA
├── service           # Regras de negócio
└── SispadApplication # Classe principal da aplicação
```

---

## 💻 Tecnologias Utilizadas

<div style="display: inline_block">
  <img alt="Java" src="https://img.shields.io/badge/Java-17-007396?style=for-the-badge&logo=java&logoColor=white">
  <img alt="Spring Boot" src="https://img.shields.io/badge/Spring_Boot-3.0.0-6DB33F?style=for-the-badge&logo=spring&logoColor=white">
  <img alt="MySQL" src="https://img.shields.io/badge/MySQL-8.0-4479A1?style=for-the-badge&logo=mysql&logoColor=white">
</div>

---

## 🚀 Como Rodar o Projeto

### Pré-requisitos

- Java 17+ instalado.
- Maven configurado.
- Banco MySQL rodando e acessível localmente.

### Passos

1. Clone o repositório:
```bash
git clone https://github.com/ErnandesNeponuceno/spring-boot-api-sispad.git

```

2. Configure o `application.properties`:
```properties
spring.datasource.url=jdbc:mysql://localhost:3306/sispad
spring.datasource.username=root
spring.datasource.password=root
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
```

3. Compile e execute o projeto:
```bash
mvn clean install
mvn spring-boot:run
```

4. Acesse a API:
```
http://localhost:8080/usuarios
```

---

## 🔍 Endpoints da API

### Usuário

- `GET /usuarios/listar` – Lista todos os usuários.
- `GET /usuarios/{id}` – Consulta um usuário pelo ID.
- `POST /usuarios` – Cria um novo usuário.
  - Corpo esperado:
  ```json
  {
    "txNome": "Ernandes Neponuceno",
    "stStatus": "A"
  }
  ```
- `PUT /usuarios/{id}` – Atualiza os dados de um usuário existente.
- `DELETE /usuarios/deletar/{id}` – Remove um usuário.

---

## 📄 Referências

- [Documentação Spring Boot](https://spring.io/projects/spring-boot)
- [Documentação Hibernate](https://hibernate.org/orm/documentation/)
- [Documentação MySQL](https://dev.mysql.com/doc/)

---

## ✨ Créditos

Desenvolvido por **Ernandes Neponuceno** como parte de estudo e prática com APIs REST em Java com Spring Boot.

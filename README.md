# Sports API

Este projeto é uma API REST para gerenciamento de atletas e modalidades esportivas, desenvolvida com **Spring Boot** e **Hibernate**.

## Tecnologias Utilizadas
- **Java 21**
- **Spring Boot 3**
- **Spring Data JPA**
- **Hibernate**
- **PostgreSQL / MySQL**
- **Lombok**
- **Maven**
- **JWT para autenticação**

## Configuração do Projeto

### 1. Clonar o repositório
```bash
git clone https://github.com/Francielefernandes06/sports-api.git
cd sports-api
```

### 2. Configurar o Banco de Dados
Altere as configurações do banco no arquivo `application.properties` ou `application.yml`.

#### **Exemplo (PostgreSQL)**:
```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/sports_db
spring.datasource.username=seu_usuario
spring.datasource.password=sua_senha
spring.jpa.hibernate.ddl-auto=update
```

### 3. Executar o projeto
```bash
mvn spring-boot:run
```

## Endpoints Principais

### 1. **Atletas**
- **Criar Atleta**
  ```http
  POST /atletas
  ```
  **Corpo da requisição:**
  ```json
  {
    "nome": "João da Silva",
    "idade": 25,
    "modalidadeId": 1
  }
  ```

- **Listar Atletas com Paginação**
  ```http
  GET /atletas?page=0&size=5
  ```

### 2. **Modalidades**
- **Criar Modalidade**
  ```http
  POST /modalidades
  ```
  **Corpo da requisição:**
  ```json
  {
    "nome": "Futebol"
  }
  ```

- **Listar Modalidades**
  ```http
  GET /modalidades
  ```

## Autenticação JWT
Esta API utiliza **JSON Web Token (JWT)** para autenticação.
- **Obter Token:**
  ```http
  POST /auth/login
  ```
  **Corpo da requisição:**
  ```json
  {
    "username": "admin",
    "password": "senha"
  }
  ```
- **Usar Token nas requisições protegidas:**
  ```http
  Authorization: Bearer SEU_TOKEN_AQUI
  ```

## Contribuição
1. Fork o repositório
2. Crie uma branch (`feature/minha-feature`)
3. Commit suas alterações (`git commit -m 'Adiciona nova funcionalidade'`)
4. Push para a branch (`git push origin feature/minha-feature`)
5. Abra um Pull Request

## Licença
Este projeto está sob a licença MIT. Veja o arquivo [LICENSE](LICENSE) para mais detalhes.

---
Desen
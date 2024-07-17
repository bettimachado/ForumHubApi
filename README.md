# Challenge Forum Hub API

## Descrição
ForumHub é uma API desenvolvida em  Java, Spring Boot e outras tecnologias para o gerenciamento de tópicos do fórum online 
de dúvidas do curso Oracle Next Education. 

A API permite a inclusão, exclusão, consultas, gerais ou específicas e
alteração de informações  dos tópicos postados pelos usuários.

Todas as entradas de dados seguiram regras de validação. 


## Funcionalidades

As requisições utilizadas  no Insomnia foram:

- POST - Autenticação de usuário com o retorno de Token JWT
- GET - Listar todos os tópicos
- GET - Listar um tópico específico
- POST - Registrar novo tópico
- PUT - Atualizar tópico específico
- DEL - Deletar tópico específico

Para registrar as operações das funcionalidades, foi criado um banco 
de dados MySQL localmente; com as tabelas: usuários e topicos.

Nas requisições de GET para listagem, foram utilizadas exibições diferentes, conforma
orientação dos cards do Trello.


## Tecnologias Utilizadas

Foram utilizadas as seguintes tecnologias para desenvolver a funcionalidade Forum Hub API:

- Java 17
- Spring Boot
- Spring Security
- Auth0
- Maven
- MySQL
- Lombok
- Flyway 
- Validation
- Spring Security 
- IntelliJ
- Insomnia
- Trello
- GIT e GITHUB



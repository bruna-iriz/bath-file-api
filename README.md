## API Conversations Batch

API criada com objetivo de ler registros de arquivo (csv), armazenar os dados em um banco de dados e gerenciar
conversas.

### :wrench: Tecnologias utilizadas

- Linguagens [Java 11, Javascript, CSS e HTML]
- Frameworks [SpringBoot, SpringBatch, SpringMVC, Maven]
- Banco de dados [MySQL]
- Script e versionamento do banco de dados [Flyway]
- Documentação [Swagger]
- Testes unitários [JUnit 5]
- Coverage [Jacoco]

### :rocket: Execução da API - Padrão

Realizar o clone do projeto:

```sh
$ git clone https://github.com/bruna-iriz/bath-file-api.git
```

Executar o clean e instalação do Maven na pasta do projeto:

```sh
$ mvn clean install
```

### :rocket: Execução da API - Docker (a validar se executa corretamente, pois aprensentou instabilidade)
Executar o clean e instalação do Maven na pasta do projeto:

```sh
$ mvn clean install
```
```sh
$ mvn clean package
```
```sh
$ docker-compose up --build
```

### Links Uteis

| Descrição | Link   | Status |
| ------     | ------ | ------ |
| Swagger | http://localhost:8080/api/swagger-ui.html| (OK) |
| Página - Gerenciador API Conversation | http://localhost:8080/index.html | (em andamento) |
| Página - Registros API Conversation | http://localhost:8080/conversation.html | (em andamento) |

### Coverage

Execute a linha de comando maven:
```sh
mvn clean verify
```
| Descrição | Link | Status |
| ------     | ------ | ------ |
| Relatório de cobertura de testes | target/site/jacoco/index.html | (em andamento: cobertura atual 73%)

![img.png](img.png)


### Documentação da API

Endpoints:

| HTTP | ENDPOINT   | DESCRIÇÃO - STATUS |
| ------     | ------ | ------ |
|POST   |http://localhost:8080/v1/conversations/batch | Ler arquivo csv e salvar no banco de dados (OK) |
|GET    |http://localhost:8080/v1/conversations | Listar todas as conversas (OK) | 
|GET    |http://localhost:8080/v1/conversations/{id}| Listar conversa por Id  (OK) |
|DELETE |http://localhost:8080/v1/conversations/{id}| Deletar conversa por Id (OK) |

- A coleção com as chamadas através do Postman está no diretório: ```./conversations-batch-api/postman```

### :soon: BACKLOG - Melhorias

- **API/Código:**
  - Tratamento de erros/exceptions
  - Melhoria na estrutura de camadas e design do projeto
  - Melhoria de logs
  - Validação do arquivo csv
  - Agendamento automático de leitura do arquivo
  - Incluir paginação ao listar todas conversas
  - Melhoria no layout das páginas

- **TESTES | QUALIDADE:**
  - Arquitetura de código [ArchUnit]
  - Qualidade de código [SonarQube]
  - Criar novos cenários de testes e aumentar o coverage

- **CONTEINERIZÇÃO:**
  - Empacotamento do código/bilbilotecas (em andamento) [Docker]

- **OBSERVABILIDADE & MONITORIA**


> :construction: Projeto em construção :construction:
---

# Animal Service API

## Visão Geral

Este projeto consiste em uma API desenvolvida para gerenciar os animais de um abrigo, permitindo o cadastro de novos animais, a busca por animais adotados e não adotados, além de fornecer estatísticas sobre os resgates realizados por funcionários ao longo de um ano.

## Funcionalidades

- **Cadastro de Animais**: Permite registrar novos animais no sistema, independente da espécie. O registro inclui detalhes como o estado de saúde do animal ao chegar, a data de resgate e o funcionário responsável pelo resgate.
  
- **Consulta de Animais**: A API oferece endpoints para listar todos os animais, filtrando por espécie, e permite diferenciar entre animais adotados e não adotados.
  
- **Estatísticas de Resgates**: Um endpoint específico retorna a contagem de animais resgatados por cada funcionário dentro de um período de um ano.

## Estrutura do Projeto

O projeto está organizado em pacotes para uma clara separação de responsabilidades:

- **Controllers**: Contém os controladores que lidam com as requisições HTTP e direcionam as operações para os serviços e repositórios apropriados.
  
- **Entidades**: Modela os dados dos animais e dos funcionários, mapeando-os para tabelas no banco de dados.
  
- **Repositórios**: Contém as interfaces responsáveis pela comunicação com o banco de dados, utilizando Spring Data JPA para abstrair as operações de persistência.

## Principais Tecnologias e Bibliotecas

- **Spring Boot**: Framework principal utilizado para a construção da API.
  
- **H2 Database**: Banco de dados utilizado em memória para fins de desenvolvimento e testes.
  
- **Spring Data JPA**: Biblioteca que facilita o acesso aos dados através da implementação de repositórios baseados em JPA.

## Exemplos de Endpoints

### Cadastro de Animal

```bash
POST /animais
```

**Exemplo de corpo da requisição:**

```json
{
  "nomeProvisorio": "Rex",
  "idadeEstimada": 3,
  "raca": "SRD",
  "especie": "cão",
  "dataEntrada": "2023-01-01",
  "condicoesChegada": "Saudável",
  "nomeRecebedor": "Erico",
  "porte": "Médio"
}
```

### Consulta de Animais Não Adotados

```bash
GET /animais/not-adopted
```

**Parâmetro opcional:**

- `especie`: Filtra a busca por uma espécie específica (ex.: "cão", "gato").

### Contagem de Resgates por Funcionário

```bash
GET /funcionarios/rescue-count
```

**Parâmetros obrigatórios:**

- `startDate`: Data de início do período (formato: YYYY-MM-DD).
- `endDate`: Data de término do período (formato: YYYY-MM-DD).

--- 
## Contribuições

Sinta-se à vontade para contribuir com melhorias. Faça um fork do projeto, crie uma branch para sua feature e envie um pull request.

---


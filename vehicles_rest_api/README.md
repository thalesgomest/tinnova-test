# 🚗 API de Veículos

Esta API foi desenvolvida em Java utilizando Spring Boot e H2 Database. Ela permite gerenciar informações sobre veículos, oferecendo diversos endpoints para interagir com os dados.

## 📃 Requisitos

Antes de começar, você precisará de:

- Java 11 ou superior
- Maven
- Spring Boot

## 🛠 Como Baixar o Repositório

Para começar, baixe o repositório:

```bash
git clone https://github.com/thalesgomest/tinnova-test.git
cd vehicles_rest_api

```

## ⚙ Como Instalar as Dependências


Com o repositório baixado, execute o seguinte comando para instalar as dependências do projeto:

```bash
./mvnw install
```
Isso vai baixar todas as dependências necessárias para rodar o projeto.

## 💻 Como Executar o Projeto

Para rodar o servidor Spring Boot, execute:

```bash
./mvnw spring-boot:run
```
A aplicação estará rodando em `http://localhost:8080`.

## 🗃 Banco de Dados

O projeto utiliza o H2 Database como banco de dados. O banco de dados pode ser acessado em `http://localhost:8080/h2-console`. O username e password padrão do H2 Database é `sa` não há password. Estas informações podem ser alteradas em `src/main/resources/application.properties`.

O banco H2 Datase está configurado para ser um banco em memória, então ele será deletado ao reiniciar o servidor.
Há um script SQL no `src/main/resources/data.sql` é executado ao iniciar o servidor para popular o banco de dados. Ele cria 10 veículos diferentes, com dados distintos.

## 🌐 Documentação da API

### Endpoints

A API oferece os seguintes endpoints:

- `GET /veiculos`: Retorna uma lista de veículos.
- `GET /veiculos/{id}`: Retorna um veículo específico.
- `GET /veiculos?marca={marca}&ano={ano}&cor={cor}`: Retorna os veículos filtrados pelos parâmetros de marca, ano e cor.
- `GET /veiculos/unsold`: Retorna os veículos não vendidos.
- `GET /veiculos/brand`: Retorna a contagem de veículos por marca.
- `GET /veiculos/decade`: Retorna a contagem de veículos por década de acordo com os anos dos mesmos.
- `GET /veiculos/lastweek`: Retorna os veículos criados durante a ultima semana.
- `POST /veiculos`: Cria um novo veículo.
- `PUT /veiculos/{id}`: Atualiza um veículo existente.
- `PATCH /veiculos/{id}`: Atualiza parcialmente um veículo existente.
- `DELETE /veiculos/{id}`: Exclui um veículo existente.


O body das requisições POST, PUT e PATCH deve ser um JSON no formato:

```go
{
  "nome": "Palio", // Obrigatorio, deve ser um string
  "marca": "FIAT", // Obrigatorio, deve ser um enum VehicleBrands
  "ano": 2002, // Obrigatorio, deve ser um integer
  "cor": "Branco", // Obrigatorio, deve ser um string
  "descricao": "Fiat Palio 2018, otimo para quem busca um carro compacto e economico.", // Opcional, deve ser um string
  "vendido": false // Obrigatorio, deve ser um boolean
}
```

A propriedade `vendido` deve ser um booleano.
A propriedade `marca` foi definida com o enum `VehicleBrands` para garantir a consistência dos dados fornecidos.

O enum `VehicleBrands` possui os seguintes valores:

```java
public enum VehicleBrands {
  FORD("FORD"),
  CHEVROLET("CHEVROLET"),
  TOYOTA("TOYOTA"),
  HONDA("HONDA"),
  FIAT("FIAT"),
  NISSAN("NISSAN"),
  BMW("BMW"),
  MERCEDES("MERCEDES"),
  AUDI("AUDI"),
  VOLKSWAGEN("VOLKSWAGEN");
}
```

## 🛠 Tecnologias Utilizadas
- Java 17
- Spring Boot
- Maven
- Spring Data JPA
- H2 Database
- Lombok

## 📩 Contato

Se você tiver alguma duvida, por favor entre em contato com pelo e-mail `thalestargino@gmail.com`.







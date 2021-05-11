# Projeto desenvolvido durante bootcamp da Digital Innovation One
Desenvolvendo um sistema de busca por cidades e estados do Brasil e países em uma API REST com Spring Boot

###Principais Tecnologias
* Java
* Spring Framework
* Postgres
* Docker
* Linux

### Etapas de criação do projeto

* Setup inicial de projeto com o Spring Boot Initialzr
* Clone do repositório sql no github com os dados da api
* Criação das entidades;
* Desenvolvimento de operações de gerenciamento ao acesso dos dados
* Desenvolvimento da busca pela distância em milhas e em metros entre duas coordenadas de latitude e longitude
* Desenvolvimento de testes unitários simples (utilizando-se de Mockito e JUnit) para validação das funcionalidades
* Refatoração

## Base de Dados

### Container Postgres

* [Postgres Docker Hub](https://hub.docker.com/_/postgres)
#### Criação do container
```shell script
docker run --name cities-db -d -p 5432:5432 -e POSTGRES_USER=postgres_user_city -e POSTGRES_PASSWORD=super_password -e POSTGRES_DB=cities postgres
```

### Dados clonados de repositório do github

* [data](https://github.com/chinnonsantos/sql-paises-estados-cidades/tree/master/PostgreSQL)

#### Inserção dos dados no container
```shell script
cd ~/workspace/sql-paises-estados-cidades/PostgreSQL

docker run -it --rm --net=host -v $PWD:/tmp postgres /bin/bash

psql -h localhost -U postgres_user_city cities -f /tmp/pais.sql
psql -h localhost -U postgres_user_city cities -f /tmp/estado.sql
psql -h localhost -U postgres_user_city cities -f /tmp/cidade.sql

psql -h localhost -U postgres_user_city cities
```
#### Acesso ao container e o usuário do banco de dados
```shell script
docker exec -it cities-db /bin/bash
psql -U postgres_user_city cities
```
#### Utiliação das extensões do Postgres para cálculo de coordenadas
```shell script
CREATE EXTENSION cube; 
CREATE EXTENSION earthdistance;
```

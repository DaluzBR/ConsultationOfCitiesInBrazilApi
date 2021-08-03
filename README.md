# DESAFIO DE PROJETO: API Rest de consulta de cidades do Brasil

<hr />

### Descrição

<p>
API Rest de consulta de cidades do Brasil com dados comparativos. Popular o banco de dados Postgres e criar um serviço para o cálculo de distância entre cidades.
</p>

### Aviso

<p>O presente repositório trata-se de um exemplo de projeto para meu próprio aprendizado. Portanto, os arquivos aqui presentes são disponibilizados "como estão". Caso o leitor tenha algum interesse neste repositório, tenha em mente que de forma alguma o criador deste repositório se responsabiliza por qualquer dano, prejuízo ou adversidades que o leitor venha a ter em decorrência do suposto uso do material aqui presente. Caso o leitor queira usar o material presente neste repositório, o mesmo deve ter também em mente que é por sua própria conta e risco.</p>

### Requisitos

<p>* IDE IntelliJ IDEA 2021.1.3 (Community Edition) para construção do back-end em Java.</p>
<p>* Java 11 ou versões superiores.</p>
<p>* Postman v8.9.1.</p>
<p>* Docker v20.10.7.</p>
<p>* PostgreSQL</p>

### Configurações

<p>+ Endereços da API em Java.</p>

```
http://localhost:8080/api/v1/states
http://localhost:8080/api/v1/countries
http://localhost:8080/api/v1/cities
http://localhost:8080/api/v1/distances/by-points?from=3658&to=5270
http://localhost:8080/api/v1/distances/by-cube?from=3658&to=5270
```

### Banco de dados

#### PostgreSQL

* [PostgreSQL Docker Hub](https://hub.docker.com/_/postgres)

```shell script
docker run --name cities-db -d -p 5432:5432 -e POSTGRES_USER=postgres_user_city -e POSTGRES_PASSWORD=super_password -e POSTGRES_DB=cities postgres
```

Aviso (Windows): O PostgreSQL será usado no docker. Se uma versão do PostgreSQL já estiver sido instalada no computador, a mesma deverá ter sua execução encerrada para evitar o erro:
"org.hibernate.HibernateException: Access to DialectResolutionInfo cannot be null when 'hibernate.dialect' not set" quando colocar a API em execução.

#### Popular banco de dados

```shell script
cd ~/workspace/sql-paises-estados-cidades/PostgreSQL

// Linux
docker run -it --rm --net=host -v $PWD:/tmp postgres /bin/bash

// Windows
docker run -it --rm --net=host -v <path>:/tmp postgres /bin/bash

psql -h localhost -U postgres_user_city cities -f /tmp/pais.sql
psql -h localhost -U postgres_user_city cities -f /tmp/estado.sql
psql -h localhost -U postgres_user_city cities -f /tmp/cidade.sql

psql -h localhost -U postgres_user_city cities

CREATE EXTENSION cube; 
CREATE EXTENSION earthdistance;
```

* [PostgreSQL Earth distance](https://www.postgresql.org/docs/current/earthdistance.html)
* [earthdistance--1.0--1.1.sql](https://github.com/postgres/postgres/blob/master/contrib/earthdistance/earthdistance--1.0--1.1.sql)
* [OPERATOR <@>](https://github.com/postgres/postgres/blob/master/contrib/earthdistance/earthdistance--1.1.sql)
* [postgrescheatsheet](https://postgrescheatsheet.com/#/tables)
* [datatype-geometric](https://www.postgresql.org/docs/current/datatype-geometric.html)

#### Acesso

```shell script
docker exec -it cities-db /bin/bash

psql -U postgres_user_city cities
```

#### Query Earth Distance

Point

```roomsql
select ((select lat_lon from cidade where id = 4929) <@> (select lat_lon from cidade where id=5254)) as distance;
```

Cube

```roomsql
select earth_distance(
    ll_to_earth(-21.95840072631836,-47.98820114135742), 
    ll_to_earth(-22.01740074157715,-47.88600158691406)
) as distance;
```

## Spring Boot

* [https://start.spring.io/](https://start.spring.io/)

+ Java 8
+ Gradle Project
+ Jar
+ Spring Web
+ Spring Data JPA
+ PostgreSQL Driver

### Spring Data

* [jpa.query-methods](https://docs.spring.io/spring-data/jpa/docs/current/reference/html/#jpa.query-methods)

### Properties

* [appendix-application-properties](https://docs.spring.io/spring-boot/docs/current/reference/html/appendix-application-properties.html)
* [jdbc-database-connectio](https://www.codejava.net/java-se/jdbc/jdbc-database-connection-url-for-common-databases)

### Types

* [JsonTypes](https://github.com/vladmihalcea/hibernate-types)
* [UserType](https://docs.jboss.org/hibernate/orm/3.5/api/org/hibernate/usertype/UserType.html)

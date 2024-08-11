# Spring_RestAPI_Microservices_Kubernetes

### Steps to create a new project -

Steps – 
```
1. Visit start.spring.io, then select below options
Project -> Maven Project 
Language -> JAVA 
Select version 
Name the Project meta data as er your need 
 

1. Click on add dependencies with below dependencies 
Spring Web 
Spring Data JPA 
H2 DB 
Spring Boot Dev Tools 
 
1. Click Generate and download the file into local pc. 

1. Extract and Open the Eclipse. 

1. Open the project using Existing Maven projects 

1. In the project structure, the file under ‘src/main/java’ can be run as Java Application 
```
Server is up..! 

Hello World 

### MySql Docker Commands -

docker run --detach --env MYSQL_ROOT_PASSWORD=dummypassword --env MYSQL_USER=bunty --env MYSQL_PASSWORD=dummypassword --env MYSQL_DATABASE=social-media-database --name mysql --publish 3306:3306 mysql:8-oracle

### mysqlsh commands

  docker exec -it mysql bash -l
  mysqlsh
  \connect social-media-user@localhost:3306
  \sql
  use social-media-database
  select * from user_details;
  select * from post;
  \quit


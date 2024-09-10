# Spring Course
[Udemy Link](https://www.udemy.com/course/microservices-with-spring-boot-and-spring-cloud)

- There are multiple workspaces in this repository created to understand the concepts of web development followed by the deployment of the application in the Google Cloud.
- The course has helped me clear a lot of concepts and helped me to align practical experience with theoretical concepts.

### Project Description

1. CentralisedConfiguration
```
This project includes concepts related to centralising a configuration using a simple folder of .properties files
```
2. LoadBalancerEureka
```
This project demonstrates the usage of a Eureka Naming server and a load balancer for creating scalable applications
```
3. SpringBootBasic
```
All the basic content of a Spring Boot Application is experimented with in this project including basic Java Concepts (OOPS Concepts) and usage of data structures
```

Moto of this repository is to get a clear idea of designing a web application based on Spring Boot and technically go through the concepts.

## URLS for testing :
- Currency Exchange Service
	- 
- Currency Conversion Service
	- http://localhost:8100/currency-conversion/from/AUD/to/INR/quantity/10
	- http://localhost:8100/currency-conversion-feign/from/EUR/to/INR/quantity/10
- Eureka
	- http://localhost:8761/
- API GATEWAY
	- http://localhost:8765/SERVICE_NAME_FROM_EUREKA/URL_TO_API
	- http://localhost:8765/CURRENCY-EXCHANGE-SERVICE/currency-exchange/from/EUR/to/INR
	- http://localhost:8765/CURRENCY-CONVERSION-SERVICE/currency-conversion-feign/from/EUR/to/INR/quantity/10

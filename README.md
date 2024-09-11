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
	
# Create docker images

## 1. pom.xml changes
	
	---
	<!-- Below plugin is used to create docker images with ease -->
	<build>
		<plugins>
			<plugin>
				<groupId>org.springframework.boot</groupId>
				<artifactId>spring-boot-maven-plugin</artifactId>
				<configuration>
					<image>
						<name>
							bunty27/smd-${project.artifactId}:${project.version}
						</name>
					</image>
					<pullPolicy>
						IF_NOT_PRESENT
					</pullPolicy>
				</configuration>
			</plugin>
		</plugins>
	</build>
	---

## 2. Ecplise

	In Ecplise --> Right click Project --> Run as --> Maven Build --> Under Main Tab --> Goals : spring-boot:build-image -DskipTests
	In cmd --> mvm spring-boot:build-image -DskipTests
	
	
	
# Configure Google Cloud Kubernetes Clusters

## Steps to start GKE and Connect using Cloud Shell terminal

1. Activate GKE with free trial versions
2. Start a GKE with default settings
3. Now open the Cloud Shell in new Terminal
4. Copy the command to connect to this clusters from Connect tab icon
5. Run the command in the GKE

## Commands to run

1. kubectl version --> Shows the verion of the kubernetes
2. kubectl create deployment hello-world-rest-api --image in28min/hello-world-rest-api:0.0.1.RELEASE
	- This image comes from docker repo, you can create your own images to directly start with your own projects
	- This command creates a new deployment in the cloud
3. kubectl expose deployment hello-world-rest-api --type=LoadBalancer --port=8080
	- Expose the application to the outside world
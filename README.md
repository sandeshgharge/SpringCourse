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
	- During creation deployment, replicaset and pod are created
	
3. kubectl expose deployment hello-world-rest-api --type=LoadBalancer --port=8080
	- Expose the application to the outside world
	- During this call, service is created
	
4. kubectl get events --sort-by=.metadata.creationTimestamp
	- List down all the events
	
5. kubectl get pods -0 wide
6. kubectl get replicaset
7. kubectl get deployment
	- Display respective details

8. kubectl scale deployment hello-world-rest-api --replicas=3
	- Desired number of pods changed to 3
	- Now 3 replicas are maintained
	
9. kubectl delete pods pod_id
	- 

10. kubectl set image deployment image_name container_name=new_image_name
	- Will update the ongoing container to a updated version of the application
	- In case there is some error, previous image continous to run without disturbing the deployment

11. kubectl get componentstatuses
	- Shows status of master nodes
	
# Kubernetes Concepts (GKE)

All the independent modules are known or linked through *Labels* and *Selectors*.
*Annotations* are used to keep track of author name, release id, build id etc.

Basic terminologies and concepts -

### 1. Pods (kubectl explains pods)
	- Smallest deployable unit, collection of containers
	- Container has to be in a pod to get deployed
	- kubectl get pods -0 wide
	- kubectl describe pod pid_id
	- kubectl delete pods pod_id

### 2. Namespace
	- Defined to confine set of deployments
	- E.g. QA, DEV, PROD environment

### 3. Replicasets (kubectl explain replicaset)
	- Monitors pods and creates if the number of pods are less than desired number
	- kubectl get rs/replicaset/replicasets
	- kubectl scale deployment hello-world-rest-api --replicas=3

### 4. Deployments
	- Used to update the version of the application
	- Once a successful deployment is executed with latest version, previous pods versions are scaled down and deleted
	
### 5. Deployment Strategy
	1. Rolling Updates (Default)
		- Same as explained above, previous version pods are scaled down with new version pod scaled up simultaneously.
		- Once desired number of pods are up with latest versions, old pods are deleted.
		- In case the new version has errors, previous versions continuous to run safely
		
	2. 
	
### 6. Service
	- Ip that is exposed to outside world is constant as it is a service that is exposed
	- There are changes happening in the backgroud, creation, updation and deletion of pods which results in change in IP address of the internal pods.
	- But the ip of the service remains constant.
	
### 7. Nodes
##### 1. Master Node
		- It stores the data related to the kubernetes modules e.g. pods creation and deletion. scaling changes etc.
		- This node has following data present
			1. API Server
				- All the commands that runs through command line involves communication between cluster, console, cloud etc.
				- All these communication are carried by API Server
				
			2. Distributed DB (etcd)
				- Stores detailed information of the actions taken on the cluster
				
			3. Scheduler
				- Scheduling pods as per needs across multiple nodes is taken care by this module which takes resources into consideration before taking any decision.
				- Resouces - available port, memory, CPU,...
				
			4. Controller Manager
	
##### 2. Worker Node
		- All the user application runs on this node
		- Components present in this node are -
			1. Node Agent (kubelet)
				- It make sure to monitors the nodes and communicates to master node.
				- In case a pod is down it communicates to Controller Manager of Master Node.
				
			2. Networking Component (kube-proxy)
				- Creates deployments and exposes the services around nodes
				
			3. Container Runtime
				- Docker is commonly used containerization and supports other OCI (Open Container Interface)
				
			4. PODS
				- PODS is what we talked in previous modules
				
## Cloud Shell
- Can be installed locally to administer the cloud services remotely
- Install Google Cloud SDK and kubectl
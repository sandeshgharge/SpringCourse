package com.demo.microservices.limits_service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


/**
 * Packages imported for creating this project are
 * 1. Spring Web
 * 2. Spring Boot Dev Tools
 * 3. Spring Boot Actuator
 * 4. Config Client
 */
@SpringBootApplication
public class LimitsServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(LimitsServiceApplication.class, args);
	}

}

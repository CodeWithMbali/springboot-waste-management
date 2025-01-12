package com.enviro.assessment.grad001.mbalibanda;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// @SpringBootApplication: Marks this as a Spring Boot application.
// It enables component scanning, autoconfiguration, and other Spring features.
@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		// SpringApplication.run(): Starts the Spring Boot application.
		SpringApplication.run(Application.class, args);
	}
}
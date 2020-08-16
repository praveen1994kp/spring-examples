package com.example.fitnesspartneruser;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableAutoConfiguration
@ComponentScan(basePackages = {"com.example.fitnesspartneruser"})
public class FitnesspartnerUserApplication {

	public static void main(String[] args) {
		SpringApplication.run(FitnesspartnerUserApplication.class, args);
	}

}

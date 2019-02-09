package com.example.student;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.jms.annotation.EnableJms;

@SpringBootApplication
@EnableAutoConfiguration
@EnableCaching
@EnableJms
@ComponentScan(basePackages = { "com.example.student" })
public class StudentAdminApplication {

	public static void main(String[] args) {
		SpringApplication.run(StudentAdminApplication.class, args);
	}

}

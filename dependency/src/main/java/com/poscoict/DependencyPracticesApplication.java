package com.poscoict;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

//@SpringBootApplication
@SpringBootConfiguration
@ComponentScan
@EnableAutoConfiguration
public class DependencyPracticesApplication {

	public static void main(String[] args) {
		SpringApplication.run(DependencyPracticesApplication.class, args);
	}

}

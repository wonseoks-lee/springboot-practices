package com.poscoict;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BootJpaApplication {
	
	public static void main(String[] args) {
		SpringApplication application = 
				new SpringApplication(BootJpaApplication.class);
		application.setWebApplicationType(WebApplicationType.NONE);
		application.run(args);
	}
}

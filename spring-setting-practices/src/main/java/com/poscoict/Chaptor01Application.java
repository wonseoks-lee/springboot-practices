package com.poscoict;

import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Chaptor01Application {

	public static void main(String[] args) {
//		SpringApplication.run(Chaptor01Application.class, args);
		SpringApplication application = new SpringApplication(Chaptor01Application.class);
		application.setWebApplicationType(WebApplicationType.SERVLET);
		
		// banner off
		application.setBannerMode(Banner.Mode.OFF);
		application.run(args);
	}

}

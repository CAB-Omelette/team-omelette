package com.codeup.omelette_abc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class OmeletteAbcApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(OmeletteAbcApplication.class, args);
	}
	
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(OmeletteAbcApplication.class);
	}
}
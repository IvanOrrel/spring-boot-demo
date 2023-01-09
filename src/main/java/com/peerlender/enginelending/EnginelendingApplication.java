package com.peerlender.enginelending;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@SpringBootApplication
@Configuration
public class EnginelendingApplication {

	public static void main(String[] args) {
		SpringApplication.run(EnginelendingApplication.class, args);
	}

}

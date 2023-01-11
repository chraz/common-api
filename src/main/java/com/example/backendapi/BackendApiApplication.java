package com.example.backendapi;

import com.example.backendapi.controller.CustomerController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class BackendApiApplication {

	private static Logger logger = LoggerFactory.getLogger(CustomerController.class);
	public static void main(String[] args) {
		SpringApplication.run(BackendApiApplication.class, args);}

	@Bean
	RestTemplate restTemplate() {
		return new RestTemplate();
	}

}

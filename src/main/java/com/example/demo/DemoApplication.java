package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;




@OpenAPIDefinition(
	info = @Info(
		title = "Product Service Rest Api Documentation",
		description = "Product service Api",
		version = "v1",
		contact = @Contact(
			name = "Krishna Agarwal",
			email = "goldyagarwal81@gmail.com"
		)
	)
)

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

}

package com.project.product.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@SpringBootApplication
@Configuration
@ComponentScan(basePackages = {"com.project.product"})
public class ProductAplication {

	
	public static void main(String args[]) {
		SpringApplication.run(ProductAplication.class, args);
	}
}

package com.project.product.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.web.SpringBootServletInitializer;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;

//@SpringBootApplication
//@Configuration
@EnableAutoConfiguration
@ComponentScan(basePackages = {"com.project.product"})
public class ProductAplication extends SpringBootServletInitializer{

	@Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(ProductAplication.class);
    }
	
	public static void main(String args[]) {
		ApplicationContext context = SpringApplication.run(ProductAplication.class, args);
		/*
		System.out.println("Let's inspect the beans provided by Spring Boot: ");
		
		String[] classNames = context.getBeanDefinitionNames();
		
		Arrays.sort(classNames);
		for(String className : classNames) {
			System.out.println(className);
		}*/
	}
}

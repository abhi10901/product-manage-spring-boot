package com.project.product.configuration;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@ComponentScan({"com.project.product.service"})
@Import({DAOConfig.class})
public class ServiceConfig {

}

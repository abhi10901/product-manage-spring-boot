package com.project.product.configuration;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Primary;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.http.MediaType;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.http.converter.xml.MarshallingHttpMessageConverter;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaDialect;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.stereotype.Component;
import org.springframework.web.accept.ContentNegotiationManager;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.ContentNegotiatingViewResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;
import org.springframework.web.servlet.view.XmlViewResolver;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;
import org.springframework.web.servlet.view.xml.MarshallingView;

import com.project.product.domain.Product;

@Component
@EnableWebMvc
@ComponentScan({ "com.project.product.controller" })
@Import({ ServiceConfig.class, DAOConfig.class })
public class ApplicationConfig {//extends WebMvcConfigurerAdapter{

	/*@Override
	public void configureContentNegotiation(ContentNegotiationConfigurer configurer) {
		configurer.ignoreAcceptHeader(true)
			.defaultContentType(MediaType.APPLICATION_XML);
	}*/
	
	@Bean
	public InternalResourceViewResolver viewResolver() {
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();

		viewResolver.setViewClass(JstlView.class);
		viewResolver.setPrefix("/WEB-INF/views/");
		viewResolver.setSuffix(".jsp");

		return viewResolver;
	}

	@Bean
	@Primary
	public DriverManagerDataSource dataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost:3306/test");
		dataSource.setUsername("root");
		dataSource.setPassword("");
		return dataSource;
	}

	@Bean
	public JpaVendorAdapter jpaVendorAdapter() {

		HibernateJpaVendorAdapter japVendorAdapter = new HibernateJpaVendorAdapter();
		japVendorAdapter.setShowSql(true);
		
		japVendorAdapter.setGenerateDdl(true);
		return japVendorAdapter;
	}

	@Bean
	public LocalContainerEntityManagerFactoryBean entityManagerFactoryBean() {
		LocalContainerEntityManagerFactoryBean entityManagerFactory = new LocalContainerEntityManagerFactoryBean();

		entityManagerFactory.setDataSource(dataSource());
		entityManagerFactory.setPackagesToScan("com.project.product.domain");
		entityManagerFactory.setJpaVendorAdapter(jpaVendorAdapter());
		entityManagerFactory.setJpaDialect(new HibernateJpaDialect());
		
		Properties properties = new Properties();
		properties.put("hibernate.hbm2ddl.auto", "update");
	    properties.put("hibernate.show_sql", "true");
	    properties.put("hibernate.format_sql", "true");
	    properties.put("hibernate.hbm2ddl.import_files", "product_database.sql");
	    properties.put("hibernate.ejb.naming_strategy", "org.hibernate.cfg.ImprovedNamingStrategy");
	   
		
		entityManagerFactory.setJpaProperties(properties);

		return entityManagerFactory;
	}
	
	@Bean
	public JpaTransactionManager transactionManager() {
		JpaTransactionManager transactionManager = new JpaTransactionManager();
		transactionManager.setEntityManagerFactory(entityManagerFactoryBean().getObject());
		return transactionManager;
	}
	
	@Bean
	public ResourceBundleMessageSource messageSource() {
		ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
		messageSource.setBasename("i18/messages");
		messageSource.setUseCodeAsDefaultMessage(true);
		return messageSource;
	}
	
	/*
	@Bean
	public ViewResolver contentNegotiatingViewResolver(ContentNegotiationManager manager) {
		
		ContentNegotiatingViewResolver viewResolver = new ContentNegotiatingViewResolver();
		viewResolver.setContentNegotiationManager(manager);
		
		List<ViewResolver> resolvers = new ArrayList<>();
		viewResolver.setViewResolvers(resolvers);
		
		XmlViewResolver xmlResolver = new XmlViewResolver();
		resolvers.add(xmlResolver);
		
		List<View> defaultViews = new ArrayList<>();
		viewResolver.setDefaultViews(defaultViews);
		defaultViews.add(xmlView());
		defaultViews.add(jacksonView());
		
		
		return viewResolver;
	}
	
	@Bean(name = "xmlView")
	public MarshallingView xmlView() {
		MarshallingView xmlView = new MarshallingView();
		xmlView.setContentType("application/xml");
		xmlView.setMarshaller(getXmlMarshalling());
		
		return xmlView;
	}

	@Bean
	public MappingJackson2JsonView jacksonView() {
		return new MappingJackson2JsonView();
	}
	
	@Bean(name = "jsonMessageConverter")
	public MappingJackson2HttpMessageConverter jsonMessageConverter() {
		MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter();
		return converter;
	}
	
	@Bean(name = "marshallingHttpMessageConverter")
	public MarshallingHttpMessageConverter getHttpMessageConverter() {
		MarshallingHttpMessageConverter converter = new MarshallingHttpMessageConverter();
		converter.setMarshaller(getXmlMarshalling());
		converter.setUnmarshaller(getXmlMarshalling());
		return converter;
	}
	
	@Bean
	public Jaxb2Marshaller getXmlMarshalling() {
		Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
		marshaller.setClassesToBeBound(Product.class);
		
		return marshaller;
	}*/
}

package com.spring.iiht.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Component;

@SpringBootApplication(scanBasePackages = {"com.spring.iiht"})
@EnableJpaRepositories(basePackages= {"com.spring.iiht.repository"})
@ComponentScan({"com.spring.iiht.service", "com.spring.iiht.controller"})
@EntityScan("com.spring.iiht.model")
@EnableAutoConfiguration
@Component
public class Application extends SpringBootServletInitializer {

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder)
	{
		return builder.sources(Application.class);
	}
	
	public static void main(String args[])
	{
		SpringApplication.run(Application.class, args);
		System.out.println("Application started successfuully");
	}
}

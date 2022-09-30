package com.lti.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication
@Configuration
@EnableAutoConfiguration
@ComponentScan({"com.lti.*"})
@EnableWebMvc
public class DemoSpringJdbcTemplatePractice1Application {

	public static void main(String[] args) {
		SpringApplication.run(DemoSpringJdbcTemplatePractice1Application.class, args);
	}

}

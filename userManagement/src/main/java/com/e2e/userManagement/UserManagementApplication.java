package com.e2e.userManagement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@SpringBootApplication
public class UserManagementApplication {

	public static void main(String[] args) {
		ApplicationContext appContext = SpringApplication.run(UserManagementApplication.class, args);
		printBeanNames(appContext);
	}

	public static void printBeanNames(ApplicationContext appContext) {
		System.out.println("----------------------------------------------------------------------");
		String[] beans = appContext.getBeanDefinitionNames();
		for (String bean : beans) {
			System.out.println(bean);
		}
		System.out.println("----------------------------------------------------------------------");
	}
	@Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurerAdapter() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/**").allowedOrigins("*");
			}
		};
	}
}

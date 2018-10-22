package com.e2e.userManagement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

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
}

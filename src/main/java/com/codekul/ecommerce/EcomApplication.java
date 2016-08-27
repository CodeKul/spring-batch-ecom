package com.codekul.ecommerce;

import org.hibernate.SessionFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class EcomApplication {

	public static void main(String[] args) {
		for (String s : SpringApplication.run(EcomApplication.class, args).getBeanDefinitionNames()) {
			System.out.println("---->"+s);
		}
	}
}

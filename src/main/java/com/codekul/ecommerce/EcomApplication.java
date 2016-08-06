package com.codekul.ecommerce;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class EcomApplication {

	public static void main(String[] args) {

		ApplicationContext context =
				SpringApplication.run(EcomApplication.class, args);
	}
}

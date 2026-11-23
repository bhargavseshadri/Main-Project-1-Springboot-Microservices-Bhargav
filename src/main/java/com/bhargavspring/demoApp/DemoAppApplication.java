package com.bhargavspring.demoApp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class DemoAppApplication {

	public static void main(String[] args) {

		//Getting the ApplicationContext
		ApplicationContext context = SpringApplication.run(DemoAppApplication.class, args);

		//Using our Bean Class without creating a object
		Dev dev = context.getBean(Dev.class);
		dev.build();
	}

}

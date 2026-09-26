package com.example.SpringBootCore;

import org.springframework.context.ApplicationContext;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringBootCoreApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(SpringBootCoreApplication.class, args);

		context.getBean(OrderService.class).placeOrder();
	}

	@Bean
	public UserService getUserService(){
		return new UserService();
	}
}

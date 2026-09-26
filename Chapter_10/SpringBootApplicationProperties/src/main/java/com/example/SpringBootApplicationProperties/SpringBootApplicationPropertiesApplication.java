package com.example.SpringBootApplicationProperties;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SpringBootApplicationPropertiesApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(SpringBootApplicationPropertiesApplication.class, args);
		System.out.println("Hii Joti");

//		PaymentGateWay paymentGateWay = context.getBean(PaymentGateWay.class);


//		paymentGateWay.print();

//		paymentGateWay.setType("Paytm");
//		paymentGateWay.setRetryCount(5);

//		System.out.println(paymentGateWay.getType());
//		System.out.println(paymentGateWay.getRetryCount());
//		System.out.println(paymentGateWay.isEnabled());
//		System.out.println(paymentGateWay.getTimeout());
	}

}


// application.properties
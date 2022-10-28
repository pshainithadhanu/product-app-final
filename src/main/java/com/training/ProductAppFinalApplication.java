package com.training;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class ProductAppFinalApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProductAppFinalApplication.class, args);
		System.out.println("saved successs");
	}
	
	

}

package com.webdev.tourapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication
@ImportResource("classpath:dependencies.xml")
public class TourappApplication {

	public static void main(String[] args) {
		SpringApplication.run(TourappApplication.class, args);
	}

}

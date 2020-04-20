package com.example.apppi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class AppPiApplication {

	public static void main(String[] args) {
		SpringApplication.run(AppPiApplication.class, args);
	}

}

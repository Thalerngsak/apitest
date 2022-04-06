package com.thalerngsak.apitest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class ApitestApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApitestApplication.class, args);
	}

}

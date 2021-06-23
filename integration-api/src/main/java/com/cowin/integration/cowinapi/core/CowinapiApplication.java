package com.cowin.integration.cowinapi.core;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class CowinapiApplication {

	public static void main(String[] args) {
		SpringApplication.run(CowinapiApplication.class, args);
	}

}

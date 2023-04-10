package com.example.OGKeys;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class OgKeysApplication {

	public static void main(String[] args) {
		DatabaseCreation.createDatabase();
		SpringApplication.run(OgKeysApplication.class, args);
	}

}

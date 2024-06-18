package com.angeljava.services;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import lombok.extern.slf4j.Slf4j;

@SpringBootApplication
@Slf4j
public class DemoConfigWatcherServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoConfigWatcherServiceApplication.class, args);
		log.info("Java version: " + System.getProperty("java.version"));
		log.info("Spring Boot version: " + org.springframework.boot.SpringBootVersion.getVersion());
	}

}

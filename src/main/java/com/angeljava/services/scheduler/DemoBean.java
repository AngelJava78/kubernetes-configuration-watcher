package com.angeljava.services.scheduler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.angeljava.services.config.MyDataProperties;
import com.angeljava.services.config.MySecrets;

import lombok.extern.slf4j.Slf4j;

@Component
@EnableScheduling
@Slf4j
public class DemoBean {

	@Autowired
	MyDataProperties myDataProperties;

	@Autowired
	MySecrets mySecrets;

	@Scheduled(fixedDelay = 10000)
	public void printMessage() {

		String message = "Name: " + myDataProperties.getName() + ". Email: " + myDataProperties.getEmail();
		log.info("From configmap [demo-configmap]: {}", message);
		String secrets = "Username: " + mySecrets.getUsername() + ". Password: " + mySecrets.getPassword();
		log.info("From secret [db-secret]: {} ", secrets);

	}
}

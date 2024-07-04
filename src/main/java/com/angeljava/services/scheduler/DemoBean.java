package com.angeljava.services.scheduler;

import java.net.InetAddress;
import java.net.UnknownHostException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.angeljava.services.config.MyDataProperties;
import com.angeljava.services.config.MySecrets;
import com.angeljava.services.config.SecondConfigMap;
import com.angeljava.services.config.SecondSecret;

import lombok.extern.slf4j.Slf4j;

@Component
@EnableScheduling
@Slf4j
public class DemoBean {

	@Autowired
	MyDataProperties myDataProperties;

	@Autowired
	MySecrets mySecrets;

	@Autowired
	SecondSecret secondSecret;

	@Autowired
	SecondConfigMap secondConfigMap;

	@Scheduled(fixedDelay = 10000)
	public void printMessage() {

		log.info("Hostname: {}", getHostname());
		String message = "Name: " + myDataProperties.getName() + ". Email: " + myDataProperties.getEmail() + ". Age: "
				+ secondConfigMap.getAge();
		log.info("From configmap [demo-configmap]: {}", message);
		String secrets = "Username: " + mySecrets.getUsername() + ". Password: " + mySecrets.getPassword();
		log.info("From secret [db-secret]: {} ", secrets);

		String secondSecrets = "Url: " + secondSecret.getUrl() + ". Token: " + secondSecret.getToken();
		log.info("From secret [second-secret]: {} ", secondSecrets);
	}

	private String getHostname() {
		String hostname = "";
		try {
			InetAddress ip = InetAddress.getLocalHost();
			hostname = ip.getHostName();
		} catch (Exception ex) {
			log.error("Error en getHostname()", ex);
		}

		return hostname;
	}
}

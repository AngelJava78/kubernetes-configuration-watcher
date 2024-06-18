package com.angeljava.services.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.angeljava.services.config.MyDataProperties;
import com.angeljava.services.event.EventCatcher;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping
@Slf4j
@RefreshScope
public class DemoController {

	@Autowired
	private MyDataProperties myDataProperties;

	@Autowired
	private EventCatcher eventCatcher;

	@GetMapping
	public ResponseEntity<String> sayHello() {
		String message = "Name: " + myDataProperties.getName() + ". Email: " + myDataProperties.getEmail();
		log.info("Response: {}", message);
		return new ResponseEntity<>(message, HttpStatus.OK);
	}

	@GetMapping("/times")
	public ResponseEntity<Integer> times() {
		return new ResponseEntity<>(eventCatcher.getTimes(), HttpStatus.OK);
	}
}

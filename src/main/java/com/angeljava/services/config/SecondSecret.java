package com.angeljava.services.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import lombok.Data;

@ConfigurationProperties(prefix = "secondsecret")
@Configuration
@Data
public class SecondSecret {
	private String url;
	private String token;
}

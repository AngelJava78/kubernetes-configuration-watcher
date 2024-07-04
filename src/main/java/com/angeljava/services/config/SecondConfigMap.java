package com.angeljava.services.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import lombok.Data;

@RefreshScope
@Component
@Data
@Configuration
public class SecondConfigMap {
	@Value("${age}")
	private String age;

}
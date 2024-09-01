package com.inaction;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties
public class InactionApplication {

  	private static final Logger logger = LoggerFactory.getLogger(InactionApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(InactionApplication.class, args);
		long av_memory = Runtime.getRuntime().maxMemory(); 
		logger.debug( "Available Memory in Mega bytes(MB): [{}]", av_memory / (1024 * 1024));
	}
}

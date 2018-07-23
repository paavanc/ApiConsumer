package com.api.consumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.data.map.repository.config.EnableMapRepositories;

@SpringBootApplication
@EnableMapRepositories
public class ConsumerApplication {
	private static final Logger logger = LoggerFactory.getLogger(ConsumerApplication.class);

	public static void main(String[] args) {
		ConfigurableApplicationContext cxt = SpringApplication.run(ConsumerApplication.class, args);
		logger.info("Running on port: " + cxt.getEnvironment().getProperty("local.server.port"));
	}
}

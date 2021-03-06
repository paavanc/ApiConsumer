package com.api.consumer.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.api.consumer.manager.CBInsightsManager;
import com.api.consumer.manager.ConsumerManager;
import com.api.consumer.manager.impl.CBInsightsManagerImpl;
import com.api.consumer.manager.impl.ConsumerManagerImpl;

@Configuration
public class BeanConfig {
	@Bean
	public ConsumerManager getConsumerManager() {
		return new ConsumerManagerImpl();
	}
	@Bean
	public CBInsightsManager getCBInsightsManager() {
		return new CBInsightsManagerImpl();
	}
}

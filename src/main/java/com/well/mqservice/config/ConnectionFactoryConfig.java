package com.well.mqservice.config;

import com.rabbitmq.client.ConnectionFactory;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author zwell
 */
@Configuration
public class ConnectionFactoryConfig {

    @Bean
    public ConnectionFactory rabbitFactory() {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("124.70.155.25");
        return factory;
    }
}

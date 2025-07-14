package com.garcihard.notification.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "spring.rabbitmq.template")
public record RabbitMQProperties(
        String defaultReceiveQueue,
        String exchange,
        String routingKey
) {
}

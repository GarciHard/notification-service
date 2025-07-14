package com.garcihard.notification.service;

import com.garcihard.notification.model.dto.ReceivedMessageDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;


@Slf4j
@RequiredArgsConstructor
@Service
public class MessageReceiver {

    private final NotificationService notificationService;

    @RabbitListener(queues = "${spring.rabbitmq.template.default-receive-queue}")
    public void receiveMessage(@Payload ReceivedMessageDTO message) {
        log.info("Received message: [{}]", message);
        notificationService.processNotification(message);
    }
}

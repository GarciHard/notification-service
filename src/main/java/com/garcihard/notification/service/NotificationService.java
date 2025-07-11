package com.garcihard.notification.service;

import com.garcihard.notification.mapper.NotificationMapper;
import com.garcihard.notification.model.NotificationStatusEnum;
import com.garcihard.notification.model.dto.NotificationDTO;
import com.garcihard.notification.model.dto.ReceivedMessageDTO;
import com.garcihard.notification.model.entity.Notification;
import com.garcihard.notification.repository.NotificationRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Slf4j
@RequiredArgsConstructor
@Service
public class NotificationService {

    private final NotificationMapper mapper;
    private final NotificationRepository repository;

    @Transactional
    public void processNotification(ReceivedMessageDTO message) {
        Notification notification = mapper.toEntity(message);
        notification.setStatus(NotificationStatusEnum.UNREAD.name());

        repository.save(notification);
    }

    @Transactional(readOnly = true)
    public List<NotificationDTO> getNotificationsFromUser(UUID userId) {
        return repository.findAllByUserId(userId)
                .stream().map(mapper::toDto)
                .toList();
    }
}

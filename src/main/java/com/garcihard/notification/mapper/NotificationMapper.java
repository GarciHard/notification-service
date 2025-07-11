package com.garcihard.notification.mapper;

import com.garcihard.notification.model.dto.NotificationDTO;
import com.garcihard.notification.model.dto.ReceivedMessageDTO;
import com.garcihard.notification.model.entity.Notification;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public interface NotificationMapper {

    @Mapping(source = "userId", target = "userId")
    @Mapping(source = "taskTitle", target = "message")
    Notification toEntity(ReceivedMessageDTO messageDTO);

    NotificationDTO toDto(Notification notification);
}

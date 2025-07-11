package com.garcihard.notification.model.dto;

import java.time.Instant;
import java.util.UUID;

public record NotificationDTO(
        UUID id,
        String message,
        String status,
        Instant createdAt,
        Instant updatedAt
) {
}

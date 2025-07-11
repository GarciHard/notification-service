package com.garcihard.notification.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.Instant;
import java.util.UUID;

public record ReceivedMessageDTO(
        @JsonProperty("event_type")
        String eventType,
        @JsonProperty("task_id")
        UUID taskId,
        @JsonProperty("user_id")
        UUID userId,
        @JsonProperty("task_title")
        String taskTitle,
        Instant timestamp
)  {
}

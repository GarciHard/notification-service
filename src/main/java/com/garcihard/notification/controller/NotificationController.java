package com.garcihard.notification.controller;

import com.garcihard.notification.model.dto.NotificationDTO;
import com.garcihard.notification.service.NotificationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.UUID;

@RequiredArgsConstructor
@RequestMapping(NotificationController.BASE_URL)
@RestController
public class NotificationController {

    static final String BASE_URL = "/api/v1/notification";
    static final String AUTH_HEADER = "X-User-Id";

    private final NotificationService notificationService;

    @GetMapping
    public ResponseEntity<List<NotificationDTO>> getAllUserNotifications(
            @RequestHeader(AUTH_HEADER) String headerUserId) {
        UUID userId = validateUserId(headerUserId);
        List<NotificationDTO> response = notificationService.getNotificationsFromUser(userId);

        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    private UUID validateUserId(String userId) {
        if (userId == null || userId.isBlank()) {
            throw new IllegalArgumentException("Missing X-User-Id header.");
        }

        try {
            return UUID.fromString(userId);
        } catch (IllegalArgumentException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Invalid userId format.");
        }
    }
}

package com.example.EcommerceWebAppMonolatic.service;

import com.example.EcommerceWebAppMonolatic.dto.NotificationDTO;

import java.util.List;

public interface NotificationsService {
    void createNotification(NotificationDTO notificationDTO);
    List<NotificationDTO> allNotification();
    NotificationDTO findNotificationById(Long notificationId);

}

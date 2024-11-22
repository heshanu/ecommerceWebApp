package com.example.EcommerceWebAppMonolatic.util;

import com.example.EcommerceWebAppMonolatic.dto.NotificationDTO;
import com.example.EcommerceWebAppMonolatic.dto.OrderDTO;
import com.example.EcommerceWebAppMonolatic.entity.NotificationEntity;
import com.example.EcommerceWebAppMonolatic.entity.OrderEntity;
import org.springframework.context.annotation.Configuration;

@Configuration
public class NotificationMapper {
    public NotificationEntity notificationDTOtoNotificationEntity(NotificationDTO notificationDTO) {
        if (notificationDTO == null) {
            return null;
        }
        return NotificationEntity
                .builder()
                .id(notificationDTO.getId())
                .content(notificationDTO.getContent())
                .sender(notificationDTO.getSender())
                .recipient(notificationDTO.getRecipient())
                .build();

    }

    public NotificationDTO notificationDTOToNotificationDTO(NotificationEntity notificationEntity) {
        if (notificationEntity == null) {
            return null;
        }
        return NotificationDTO
                .builder()
                .id(notificationEntity.getId())
                .content(notificationEntity.getContent())
                .sender(notificationEntity.getSender())
                .content(notificationEntity.getContent())
                .build();

    }
}

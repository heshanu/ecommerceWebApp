package com.example.EcommerceWebAppMonolatic.service.impl;

import com.example.EcommerceWebAppMonolatic.dto.NotificationDTO;
import com.example.EcommerceWebAppMonolatic.entity.NotificationEntity;
import com.example.EcommerceWebAppMonolatic.exception.NotificationNotFoundException;
import com.example.EcommerceWebAppMonolatic.repo.NotificationRepo;
import com.example.EcommerceWebAppMonolatic.service.NotificationsService;
import com.example.EcommerceWebAppMonolatic.util.NotificationMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NotificationServiceImpl implements NotificationsService {
    private final NotificationRepo notificationRepo;
    private final NotificationMapper notificationMapper;
    @Autowired
    public NotificationServiceImpl(NotificationRepo notificationRepo, NotificationMapper notificationMapper) {
        this.notificationRepo = notificationRepo;
        this.notificationMapper = notificationMapper;
    }

    @Override
    public void createNotification(NotificationDTO notificationDTO) {
        if(notificationDTO==null){ }//throws new N}
        NotificationEntity newNotification=notificationRepo
                .save(notificationMapper.notificationDTOtoNotificationEntity(notificationDTO));
    }

    @Override
    public List<NotificationDTO> allNotification() {
        List<NotificationEntity> notificationsList=notificationRepo.findAll();
        return (List<NotificationDTO>) notificationMapper.notificationDTOToNotificationDTO((NotificationEntity) notificationsList);
    }

    @Override
    public NotificationDTO findNotificationById(Long notificationId) {
        NotificationEntity findNotification=notificationRepo.findById(notificationId)
                .orElseThrow(()->new NotificationNotFoundException("Notification not found","UNABLE_TO_FIND_NOTIFICATION"));
        return notificationMapper.notificationDTOToNotificationDTO(findNotification);
    }
}

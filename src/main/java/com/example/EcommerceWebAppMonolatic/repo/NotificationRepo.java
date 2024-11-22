package com.example.EcommerceWebAppMonolatic.repo;

import com.example.EcommerceWebAppMonolatic.entity.NotificationEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NotificationRepo extends JpaRepository<NotificationEntity,Long> {
}

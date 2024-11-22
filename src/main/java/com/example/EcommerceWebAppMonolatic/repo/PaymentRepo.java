package com.example.EcommerceWebAppMonolatic.repo;

import com.example.EcommerceWebAppMonolatic.entity.PaymentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentRepo extends JpaRepository<Long, PaymentEntity> {
}

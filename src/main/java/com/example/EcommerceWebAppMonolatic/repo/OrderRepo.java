package com.example.EcommerceWebAppMonolatic.repo;

import com.example.EcommerceWebAppMonolatic.entity.OrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepo extends JpaRepository<OrderEntity,Long> {
}

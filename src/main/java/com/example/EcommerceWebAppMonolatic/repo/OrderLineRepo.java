package com.example.EcommerceWebAppMonolatic.repo;

import com.example.EcommerceWebAppMonolatic.entity.OrderLineEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderLineRepo extends JpaRepository<OrderLineEntity,Long> {
}

package com.example.EcommerceWebAppMonolatic.service.impl;

import com.example.EcommerceWebAppMonolatic.dto.OrderDTO;
import com.example.EcommerceWebAppMonolatic.entity.OrderEntity;
import com.example.EcommerceWebAppMonolatic.repo.OrderRepo;
import com.example.EcommerceWebAppMonolatic.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class OrderServiceImpl implements OrderService {
    private final OrderRepo orderRepo;

    public OrderServiceImpl(OrderRepo orderRepo) {
        this.orderRepo = orderRepo;
    }

    @Override
    public void createOrder(OrderEntity orderEntity) {

    }

    @Override
    public List<OrderDTO> findAllOrder() {
        return List.of();
    }

    @Override
    public OrderDTO findById(Long orderId) {
        return null;
    }
}

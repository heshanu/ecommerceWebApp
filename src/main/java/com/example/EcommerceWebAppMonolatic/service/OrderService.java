package com.example.EcommerceWebAppMonolatic.service;

import com.example.EcommerceWebAppMonolatic.dto.OrderDTO;
import com.example.EcommerceWebAppMonolatic.entity.OrderEntity;

import java.util.List;

public interface OrderService {
    public void createOrder(OrderEntity orderEntity);
    public List<OrderDTO> findAllOrder();
    public OrderDTO findById(Long orderId);

}

package com.example.EcommerceWebAppMonolatic.util;

import com.example.EcommerceWebAppMonolatic.dto.CustomerDTO;
import com.example.EcommerceWebAppMonolatic.dto.OrderDTO;
import com.example.EcommerceWebAppMonolatic.entity.CustomerEntity;
import com.example.EcommerceWebAppMonolatic.entity.OrderEntity;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OrderMapper {
    public OrderEntity orderDTOtoOrderEntity(OrderDTO orderDTO) {
        if (orderDTO == null) {
            return null;
        }
        return OrderEntity.builder()
                .id(orderDTO.getId())
                .orderDate(orderDTO.getOrderDate())
                .customer(orderDTO.getCustomer())
                .orderLines(orderDTO.getOrderLines())
                .notification(orderDTO.getNotification())
                .payment(orderDTO.getPayment())
                .reference(orderDTO.getReference())
                .build();

    }

    public OrderDTO orderEntitiyToOrderDTO(OrderEntity orderEntity) {
        if (orderEntity == null) {
            return null;
        }
        return OrderDTO.builder()
                .id(orderEntity.getId())
                .orderDate(orderEntity.getOrderDate())
                .customer(orderEntity.getCustomer())
                .orderLines(orderEntity.getOrderLines())
                .notification(orderEntity.getNotification())
                .payment(orderEntity.getPayment())
                .reference(orderEntity.getReference())
                .build();
    }


    public Object orderEntityToOrderDTO(OrderEntity orderEntity){
        if (orderEntity == null) {
            return null;
        }
        return OrderDTO.builder()
                .id(orderEntity.getId())
                .orderDate(orderEntity.getOrderDate())
                .customer(orderEntity.getCustomer())
                .orderLines(orderEntity.getOrderLines())
                .notification(orderEntity.getNotification())
                .payment(orderEntity.getPayment())
                .reference(orderEntity.getReference())
                .build();

    }
}

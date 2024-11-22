package com.example.EcommerceWebAppMonolatic.dto;

import com.example.EcommerceWebAppMonolatic.entity.CustomerEntity;
import com.example.EcommerceWebAppMonolatic.entity.NotificationEntity;
import com.example.EcommerceWebAppMonolatic.entity.OrderLineEntity;
import com.example.EcommerceWebAppMonolatic.entity.PaymentEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class OrderDTO {
    private Long id;
    private LocalDateTime orderDate;
    private String reference;
    private CustomerEntity customer;
    private List<OrderLineEntity> orderLines;
    private PaymentEntity payment;
    private NotificationEntity notification;
}

package com.example.EcommerceWebAppMonolatic.dto;

import com.example.EcommerceWebAppMonolatic.entity.AddressEntity;
import org.springframework.stereotype.Component;

@Component
public class CustomerRequest {
    String id;
    String firstName;
    String lastName;
    String email;
    AddressEntity address;
}
package com.example.EcommerceWebAppMonolatic.entity;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Embeddable
@NoArgsConstructor
@Data
@AllArgsConstructor
@Builder
public class AddressEntity {
    private String street;
    private String houseNumber;
    private String zipCode;
}

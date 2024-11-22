package com.example.EcommerceWebAppMonolatic.util;

import com.example.EcommerceWebAppMonolatic.dto.CustomerDTO;
import com.example.EcommerceWebAppMonolatic.dto.CustomerRequest;
import com.example.EcommerceWebAppMonolatic.entity.AddressEntity;
import com.example.EcommerceWebAppMonolatic.entity.CustomerEntity;
import org.springframework.stereotype.Component;

@Component
public class CustomerMapper {

    public CustomerEntity customerDTOtoCustomerEntity(CustomerDTO customerDTO) {
        if (customerDTO == null) {
            return null;
        }
        return CustomerEntity.builder()
                .id(customerDTO.getId())
                .firstName(customerDTO.getFirstName())
                .lastName(customerDTO.getLastName())
                .userName(customerDTO.getUserName())
                .roles(customerDTO.getRoles())
                .email(customerDTO.getEmail())
                .addressEntity(customerDTO.getAddressEntity())
                .build();
    }

    public CustomerDTO customerEntitiyToCustomerDTO(CustomerEntity customerEntity) {
        if (customerEntity == null) {
            return null;
        }
        return CustomerDTO.builder()
                .id(customerEntity.getId())
                .firstName(customerEntity.getFirstName())
                .lastName(customerEntity.getLastName())
                .email(customerEntity.getEmail())
                .userName(customerEntity.getUserName())
                .roles(customerEntity.getRoles())
                .addressEntity(customerEntity.getAddressEntity())
                .build();
    }


    public Object customerEntityToCustomerDTO(CustomerEntity customerEntity){
        if (customerEntity == null) {
            return null;
        }
        return CustomerDTO.builder()
                .id(customerEntity.getId())
                .firstName(customerEntity.getFirstName())
                .lastName(customerEntity.getLastName())
                .email(customerEntity.getEmail())
                .userName(customerEntity.getUserName())
                .roles(customerEntity.getRoles())
                .addressEntity(customerEntity.getAddressEntity())
                .build();
    }
}

package com.example.EcommerceWebAppMonolatic.service.impl;

import com.example.EcommerceWebAppMonolatic.dto.CustomerDTO;
import com.example.EcommerceWebAppMonolatic.entity.AddressEntity;
import com.example.EcommerceWebAppMonolatic.entity.CustomerEntity;
import com.example.EcommerceWebAppMonolatic.repo.CustomerRepo;
import com.example.EcommerceWebAppMonolatic.util.CustomerMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.hamcrest.Matchers.any;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class CustomerServiceImplTest {
    @Mock
    private CustomerRepo customerRepo;

    @Mock
    private CustomerMapper customerMapper;

    @InjectMocks
    private CustomerServiceImpl customerService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void saveCustomer() {
        AddressEntity addressEntity = AddressEntity.builder()
                .street("222B")
                .houseNumber("297/2")
                .zipCode("8001")
                .build();

        CustomerDTO customerDTO = new CustomerDTO(
                4L,
                "Anjana",
                "Lakshan",
                "anjana@gmail.com",
                "gonja",
                "USER",
                addressEntity
        );

        CustomerEntity customerEntity = CustomerEntity.builder()
                .id(4L)
                .firstName("Anjana")
                .lastName("Lakshan")
                .email("anjana@gmail.com")
                .userName("gonja")
                .roles("USER")
                .addressEntity(addressEntity)
                .build();

        when(customerMapper.customerDTOtoCustomerEntity((CustomerDTO) any(CustomerDTO.class))).thenReturn(customerEntity);
        when(customerRepo.save(any(CustomerEntity.class))).thenReturn(customerEntity);
        when(customerMapper.customerEntityToCustomerDTO((CustomerEntity) any(CustomerEntity.class))).thenReturn(customerDTO);

        // Act
        CustomerDTO result = customerService.saveCustomer(customerDTO);

        // Assert
        assertEquals(customerDTO, result);
    }

    @Test
    void showAllCustomers() {
    }

    @Test
    void findById() {
    }

    @Test
    void deleteCustomer() {
    }

    @Test
    void updateCustomer() {
    }
}
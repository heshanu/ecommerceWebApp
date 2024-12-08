package com.example.EcommerceWebAppMonolatic.controller;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import com.example.EcommerceWebAppMonolatic.dto.CustomerDTO;
import com.example.EcommerceWebAppMonolatic.entity.AddressEntity;
import com.example.EcommerceWebAppMonolatic.service.impl.CustomerServiceImpl;
import com.example.EcommerceWebAppMonolatic.util.CustomerMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@ExtendWith({SpringExtension.class, MockitoExtension.class})
@WebMvcTest(CustomerController.class)
class CustomerControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @InjectMocks
    private CustomerServiceImpl customerService;

    @Mock
    private CustomerMapper customerMapper;

    @InjectMocks
    private CustomerController customerController;


    @BeforeEach
    void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(customerController).build();
    }

    @Test
    void fetchAllCustomer() throws Exception {
        // Create mock customers
        AddressEntity addressEntity1 = AddressEntity.builder()
                .houseNumber("297/2")
                .street("222B")
                .zipCode("8001")
                .build();

        AddressEntity addressEntity2 = AddressEntity.builder()
                .houseNumber("123/4")
                .street("ABC")
                .zipCode("8002")
                .build();

        CustomerDTO customer1 = CustomerDTO.builder()
                .id(1L)
                .addressEntity(addressEntity1)
                .roles("USER")
                .email("h@gmail.com")
                .firstName("heshan")
                .lastName("umayanga")
                .userName("heshan")
                .build();

        CustomerDTO customer2 = CustomerDTO.builder()
                .id(2L)
                .addressEntity(addressEntity2)
                .roles("ADMIN")
                .email("a@gmail.com")
                .firstName("alice")
                .lastName("smith")
                .userName("alice")
                .build();

        List<CustomerDTO> customers = Arrays.asList(customer1, customer2);

        // Define mock behavior
        when(customerService.showAllCustomers()).thenReturn(Collections.singletonList(customers));

        // Perform the GET request and verify the response
        mockMvc.perform(get("/api/v1/customer/")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.length()").value(2))
                .andExpect(jsonPath("$[0].id").value(1))
                .andExpect(jsonPath("$[0].email").value("h@gmail.com"))
                .andExpect(jsonPath("$[1].id").value(2))
                .andExpect(jsonPath("$[1].email").value("a@gmail.com"));
    }

    @Test
    void saveCustomer() {
    }

    @Test
    void findByCustomerId() {
    }

    @Test
    void updateCustomer() {
    }

    @Test
    void deleteByCustomerId() {
    }
}
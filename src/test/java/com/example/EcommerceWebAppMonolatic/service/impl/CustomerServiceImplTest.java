package com.example.EcommerceWebAppMonolatic.service.impl;

import com.example.EcommerceWebAppMonolatic.dto.CustomerDTO;
import com.example.EcommerceWebAppMonolatic.entity.AddressEntity;
import com.example.EcommerceWebAppMonolatic.entity.CustomerEntity;
import com.example.EcommerceWebAppMonolatic.repo.CustomerRepo;
import com.example.EcommerceWebAppMonolatic.util.CustomerMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class CustomerServiceImplTest {
    @Mock
    private CustomerRepo customerRepo;

    @InjectMocks
    private CustomerServiceImpl customerService;

    @Mock
    private CustomerMapper customerMapper;

    AddressEntity addressEntity=AddressEntity.builder()
            .houseNumber("297/2")
            .street("222B")
            .zipCode("8001").build();

    @Test
    void saveCustomer() {
        // Create a mock address entity
        AddressEntity addressEntity = AddressEntity.builder()
                .houseNumber("297/2")
                .street("222B")
                .zipCode("8001")
                .build();

        // Create a mock customer DTO
        CustomerDTO customerDTO = CustomerDTO.builder()
                .id(1L)
                .addressEntity(addressEntity)
                .roles("USER")
                .email("h@gmail.com")
                .firstName("heshan")
                .lastName("umayanga")
                .userName("heshan")
                .build();

        // Create a mock customer entity
        CustomerEntity customerEntity = CustomerEntity.builder()
                .id(1L)
                .addressEntity(addressEntity)
                .roles("USER")
                .email("h@gmail.com")
                .firstName("heshan")
                .lastName("umayanga")
                .userName("heshan")
                .build();

        // Define mock behavior
        when(customerMapper.customerDTOtoCustomerEntity(customerDTO)).thenReturn(customerEntity);
        when(customerRepo.save(customerEntity)).thenReturn(customerEntity);
        when(customerMapper.customerEntitiyToCustomerDTO(customerEntity)).thenReturn(customerDTO);

        // Call the service method
        CustomerDTO result = customerService.saveCustomer(customerDTO);

        // Verify the results
        assertNotNull(result);
        assertEquals("USER", result.getRoles());
        assertEquals("h@gmail.com", result.getEmail());
        assertEquals("heshan", result.getFirstName());
        assertEquals("umayanga", result.getLastName());
        assertEquals("heshan", result.getUserName());
    }

    @Test
    void showAllCustomers() {




    }

    @Test
    void findById() {
        // Create a mock customer
        AddressEntity addressEntity = AddressEntity.builder()
                .houseNumber("297/2")
                .street("222B")
                .zipCode("8001")
                .build();

        CustomerEntity mockCustomer = CustomerEntity.builder()
                .addressEntity(addressEntity)
                .id(1L)
                .roles("USER")
                .email("h@gmail.com")
                .firstName("heshan")
                .lastName("umayanga")
                .userName("heshan")
                .build();

        // Define mock behavior
        when(customerRepo.findById(1L)).thenReturn(Optional.of(mockCustomer));
        // Call the service method
        Optional<CustomerEntity> customer=customerRepo.findById(1L);
        // Verify the results
        assertNotNull(customer.isPresent());
        assertEquals(customer.get().getId(),1L);
    }

    @Test
    void deleteCustomer() {
        // Define mock behavior
        when(customerRepo.existsById(3L)).thenReturn(true);
        doNothing().when(customerRepo).deleteById(3L);

        // Call the service method
        customerService.deleteCustomer(3L);

        // Verify the results
        verify(customerRepo, times(1)).deleteById(3L);
    }

    @Test
    void updateCustomer() {
        // Create a mock address entity
        AddressEntity addressEntity = AddressEntity.builder()
                .houseNumber("297/2")
                .street("222B")
                .zipCode("8001")
                .build();

        // Create a mock existing customer entity
        CustomerEntity existingCustomerEntity = CustomerEntity.builder()
                .id(1L)
                .addressEntity(addressEntity)
                .roles("USER")
                .email("h@gmail.com")
                .firstName("heshan")
                .lastName("umayanga")
                .userName("heshan")
                .build();

        // Create a mock existing customer DTO
        CustomerDTO existingCustomerDTO = CustomerDTO.builder()
                .id(1L)
                .addressEntity(addressEntity)
                .roles("USER")
                .email("h@gmail.com")
                .firstName("heshan")
                .lastName("umayanga")
                .userName("heshan")
                .build();

        // Create an updated customer DTO
        CustomerDTO updatedCustomerDTO = CustomerDTO.builder()
                .id(1L)
                .addressEntity(addressEntity)
                .roles("ADMIN")
                .email("h@gmail.com")
                .firstName("heshan")
                .lastName("umayanga")
                .userName("heshan_updated")
                .build();

        // Create an updated customer entity
        CustomerEntity updatedCustomerEntity = CustomerEntity.builder()
                .id(1L)
                .addressEntity(addressEntity)
                .roles("ADMIN")
                .email("h@gmail.com")
                .firstName("heshan")
                .lastName("umayanga")
                .userName("heshan_updated")
                .build();

        // Define mock behavior
        lenient().when(customerRepo.findById(1L)).thenReturn(java.util.Optional.of(existingCustomerEntity));
        lenient().when(customerRepo.save(updatedCustomerEntity)).thenReturn(updatedCustomerEntity);
        lenient().when(customerMapper.customerDTOtoCustomerEntity(updatedCustomerDTO)).thenReturn(updatedCustomerEntity);
        lenient().when(customerMapper.customerEntitiyToCustomerDTO(updatedCustomerEntity)).thenReturn(updatedCustomerDTO);

        // Call the service method
        CustomerDTO result = customerService.updateCustomer(updatedCustomerDTO);

        // Verify the results
        assertNotNull(result);
        assertEquals("ADMIN", result.getRoles());
        assertEquals("heshan_updated", result.getUserName());
    }
}
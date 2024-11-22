package com.example.EcommerceWebAppMonolatic.service.impl;

import com.example.EcommerceWebAppMonolatic.dto.CustomerDTO;
import com.example.EcommerceWebAppMonolatic.entity.CustomerEntity;
import com.example.EcommerceWebAppMonolatic.exception.CustomerNotFoundException;
import com.example.EcommerceWebAppMonolatic.repo.CustomerRepo;
import com.example.EcommerceWebAppMonolatic.service.CustomerService;
import com.example.EcommerceWebAppMonolatic.util.CustomerMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    public CustomerServiceImpl(CustomerRepo customerRepo, CustomerMapper customerMapper) {
        this.customerRepo = customerRepo;
        this.customerMapper = customerMapper;
    }

    private final CustomerRepo customerRepo;
    private final CustomerMapper customerMapper;

    @Override
    public CustomerDTO saveCustomer(CustomerDTO customerDTO) {
        CustomerEntity customer=customerRepo.save(customerMapper.customerDTOtoCustomerEntity(customerDTO));
         return customerMapper.customerEntitiyToCustomerDTO(customer);
    }

    @Override
    public List<Object> showAllCustomers() {
        List<CustomerEntity> allCustomers= customerRepo.findAll();
        if (allCustomers.isEmpty()) {
            throw new CustomerNotFoundException("No users found", "NO_USERS_FOUND");
        }
        return allCustomers.stream()
                .map(customerMapper::customerEntityToCustomerDTO)
                .collect(Collectors.toList());
    }

    @Override
    public CustomerDTO findById(Long id) {
        CustomerEntity filteredCustomer=customerRepo.findById(id)
                .orElseThrow(()->new CustomerNotFoundException("CUSTOMER NOT FOUND","CUSTOMER_NOT_FOUND"));
        return customerMapper.customerEntitiyToCustomerDTO(filteredCustomer);
    }

    @Override
    public void deleteCustomer(Long customerId) {
        CustomerEntity filteredCustomer=customerRepo.findById(customerId)
                .orElseThrow(()->new CustomerNotFoundException("CUSTOMER NOT FOUND","CUSTOMER_NOT_FOUND"));
        customerRepo.deleteById(customerId);
    }

    @Override
    public CustomerDTO updateCustomer(CustomerDTO customerDTO) {
        CustomerEntity filteredCustomer=customerRepo.findById(customerDTO.getId())
                .orElseThrow(()->new CustomerNotFoundException("CUSTOMER NOT FOUND","CUSTOMER_NOT_FOUND"));
        CustomerEntity updateCustomer=CustomerEntity.builder()
                .email(customerDTO.getEmail())
                .roles(customerDTO.getRoles())
                .id(customerDTO.getId())
                .addressEntity(customerDTO.getAddressEntity())
                .firstName(customerDTO.getFirstName())
                .lastName(customerDTO.getLastName())
                .userName(customerDTO.getUserName())
                .build();
        customerRepo.save(updateCustomer);
        CustomerDTO updatedCustomer= customerMapper.customerEntitiyToCustomerDTO(updateCustomer);
        return updatedCustomer;
    }

}

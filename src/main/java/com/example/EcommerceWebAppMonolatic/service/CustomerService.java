package com.example.EcommerceWebAppMonolatic.service;

import com.example.EcommerceWebAppMonolatic.dto.CustomerDTO;

import java.util.List;

public interface CustomerService {
    CustomerDTO saveCustomer(CustomerDTO customerDTO);
    List<Object> showAllCustomers();
    public CustomerDTO findById(Long id);
    public void deleteCustomer(Long id);
    CustomerDTO updateCustomer(CustomerDTO customerDTO);
}

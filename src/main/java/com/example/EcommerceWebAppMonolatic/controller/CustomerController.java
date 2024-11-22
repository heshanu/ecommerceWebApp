package com.example.EcommerceWebAppMonolatic.controller;

import com.example.EcommerceWebAppMonolatic.dto.CustomerDTO;
import com.example.EcommerceWebAppMonolatic.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/customer")
public class CustomerController {
    private final CustomerService customerService;
    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("/")
    public ResponseEntity<List<Object>> fetchAllCustomer(){
        List<Object> listAllCustomer=customerService.showAllCustomers();
        return new ResponseEntity<>(listAllCustomer,HttpStatus.OK);
    }

    @PostMapping("/createCustomer")
    public ResponseEntity<CustomerDTO> saveCustomer(@RequestBody CustomerDTO customerDTO){
        CustomerDTO customer=customerService.saveCustomer(customerDTO);
        return new ResponseEntity<>(customer, HttpStatus.OK);
    }

    @GetMapping("/id")
    public ResponseEntity<CustomerDTO> findByCustomerId(@RequestParam Long customerId){
        CustomerDTO findById=customerService.findById(customerId);
        return new ResponseEntity<>(findById,HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<CustomerDTO> updateCustomer(@RequestBody CustomerDTO customerDTO){
        return new ResponseEntity<>(customerService.updateCustomer(customerDTO),HttpStatus.OK);
    }

    @DeleteMapping("/id")
    public ResponseEntity<Void> deleteByCustomerId(@RequestParam Long customerId){
        customerService.deleteCustomer(customerId);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}

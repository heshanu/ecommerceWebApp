package com.example.EcommerceWebAppMonolatic.controller;

import com.example.EcommerceWebAppMonolatic.dto.OrderDTO;
import com.example.EcommerceWebAppMonolatic.entity.OrderEntity;
import com.example.EcommerceWebAppMonolatic.service.OrderService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/order")
public class OrderController {

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    private final OrderService orderService;

    @PostMapping("/")
    public ResponseEntity<Void> createOrder(@RequestBody OrderDTO dto){
        orderService.createOrder(dto);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/")
    public ResponseEntity<List<OrderDTO>> getAllOrders(){
        List<OrderDTO> orderList=orderService.findAllOrder();
        return new ResponseEntity<>(orderList,HttpStatus.OK);
    }

    @GetMapping("/id")
    public ResponseEntity<OrderDTO> getOrderById(@RequestParam Long orderId){
        OrderDTO getOrder=orderService.findById(orderId);
        return new ResponseEntity<>(getOrder,HttpStatus.OK);
    }
}

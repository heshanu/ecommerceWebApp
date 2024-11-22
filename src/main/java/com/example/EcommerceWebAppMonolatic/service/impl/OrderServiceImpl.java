package com.example.EcommerceWebAppMonolatic.service.impl;

import com.example.EcommerceWebAppMonolatic.dto.OrderDTO;
import com.example.EcommerceWebAppMonolatic.entity.OrderEntity;
import com.example.EcommerceWebAppMonolatic.exception.OrderNotFoundException;
import com.example.EcommerceWebAppMonolatic.repo.OrderRepo;
import com.example.EcommerceWebAppMonolatic.service.OrderService;
import com.example.EcommerceWebAppMonolatic.util.OrderMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class OrderServiceImpl implements OrderService {
    private final OrderMapper orderMapper;
    private final OrderRepo orderRepo;

    public OrderServiceImpl(OrderMapper orderMapper, OrderRepo orderRepo) {
        this.orderMapper = orderMapper;
        this.orderRepo = orderRepo;
    }

    @Override
    public void createOrder(OrderDTO orderDTO) {
        OrderEntity order=orderMapper.orderDTOtoOrderEntity(orderDTO);
        orderRepo.save(order);
    }

    @Override
    public List<OrderDTO> findAllOrder() {
        List<OrderEntity> ordersList=orderRepo.findAll();
        if(ordersList.isEmpty()){
                throw new OrderNotFoundException("Order was not found","ORDER_WASNT_FOUND");
        }
        return (List<OrderDTO>) orderMapper.orderEntitiyToOrderDTO((OrderEntity) ordersList);
    }

    @Override
    public OrderDTO findById(Long orderId) {
        OrderEntity filteredOrder=orderRepo.findById(orderId)
                .orElseThrow(()->new OrderNotFoundException("Order was not found","ORDER_WASNT_FOUND"));
        return orderMapper.orderEntitiyToOrderDTO(filteredOrder);
    }
}

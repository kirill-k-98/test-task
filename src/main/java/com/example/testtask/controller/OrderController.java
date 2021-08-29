package com.example.testtask.controller;

import com.example.testtask.model.OrderRequest;
import com.example.testtask.service.OrderManagingService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController {

    private final OrderManagingService orderManagingService;

    public OrderController(OrderManagingService orderManagingService) {
        this.orderManagingService = orderManagingService;
    }

    @PostMapping("/order/process")
    public void processOrder(@RequestBody OrderRequest orderRequest) {
        orderManagingService.addOrderToQueue(orderRequest);
    }
}

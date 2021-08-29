package com.example.testtask.service;

import com.example.testtask.model.OrderRequest;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class OrderScheduler {

    private final OrderManagingService orderManagingService;

    private final OrderProcessingService orderProcessingService;

    public OrderScheduler(OrderManagingService orderManagingService, OrderProcessingService orderProcessingService) {
        this.orderManagingService = orderManagingService;
        this.orderProcessingService = orderProcessingService;
    }

    @Scheduled(fixedDelay = 100)
    public void processOrder() {
        OrderRequest orderRequest = orderManagingService.pollOrder();
        if (orderRequest != null) {
            orderProcessingService.processOrder(orderRequest);
        }
    }
}

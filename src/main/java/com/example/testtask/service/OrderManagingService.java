package com.example.testtask.service;

import com.example.testtask.model.OrderRequest;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import org.springframework.stereotype.Component;

@Component
public class OrderManagingService {

    private final BlockingQueue<OrderRequest> orderQueue = new LinkedBlockingQueue<>();

    public void addOrderToQueue(OrderRequest order) {
        orderQueue.add(order);
    }

    public OrderRequest pollOrder() {
        return orderQueue.poll();
    }
}

package com.example.testtask.service;

import com.example.testtask.model.OrderRequest;
import com.example.testtask.model.ProductEntity;
import com.example.testtask.repository.ProductRepository;
import org.springframework.stereotype.Component;

@Component
public class OrderProcessingService {

    private final ProductRepository productRepository;

    public OrderProcessingService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public void processOrder(OrderRequest order) {
        ProductEntity product = productRepository.findProductByName(order.getProductName());
        if (product == null) {
            return;
        }
        if (order.getCount() > product.getCount()) {
            return;
        }

        product.setCount(product.getCount() - order.getCount());
        productRepository.save(product);
    }
}

package com.petwal.service;

import com.petwal.repository.OrderRepository;
import com.petwal.repository.model.OrderEntity;

public class PickingService {

    private OrderRepository orderRepository;

    public PickingService(final OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public OrderEntity getOrder(final String orderId) {
        return orderRepository.findById(orderId)
                .get();
    }
}

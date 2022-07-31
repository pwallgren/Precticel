package com.petwal.service;

import com.petwal.repository.OrderRepository;
import com.petwal.service.converter.EntityToDomain;
import com.petwal.service.model.Order;

import java.util.Optional;

public class PickingService {

    private final OrderRepository orderRepository;

    public PickingService(final OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public Optional<Order> getOrder(final String orderId) {
        return orderRepository.findById(orderId)
                .map(EntityToDomain::convert);
    }
}

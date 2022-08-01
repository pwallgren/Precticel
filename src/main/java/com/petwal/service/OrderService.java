package com.petwal.service;

import com.petwal.repository.OrderRepository;
import com.petwal.service.converter.EntityToDomain;
import com.petwal.service.model.Order;

import java.util.Optional;

public class OrderService {

    private final OrderRepository orderRepository;

    public OrderService(final OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public Optional<Order> getOrder(final String orderId) {
        orderRepository.pickOrderItem("123AB", "1", 1);
        return orderRepository.findById(orderId)
                .map(EntityToDomain::convert);
    }
}

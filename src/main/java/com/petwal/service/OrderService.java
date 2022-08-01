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
        return orderRepository.findById(orderId)
                .map(EntityToDomain::convert);
    }

    public void pickOrderItem(final String orderId, final String pickId, final String deviceId, final int amount) {
        orderRepository.pickOrderItem(orderId, pickId, deviceId, amount);
    }

    public void startRandomOrder(final String deviceId) {
        orderRepository.startRandomOrder(deviceId);
    }

    public void startSpecificOrder(final String deviceId, final String orderId) {
        orderRepository.startSpecificOrder(deviceId, orderId);
    }
}

package com.petwal.rest.service;

import com.petwal.rest.converter.DomainToApi;
import com.petwal.rest.model.ApiOrder;
import com.petwal.service.OrderService;

import java.util.Optional;

public class ApiOrderService {

    private final OrderService orderService;

    public ApiOrderService(final OrderService orderService) {
        this.orderService = orderService;
    }

    public Optional<ApiOrder> getOrder(final String orderId) {
        return orderService.getOrder(orderId)
                .map(DomainToApi::convert);
    }

}

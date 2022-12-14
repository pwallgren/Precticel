package com.petwal.rest.service;

import com.petwal.rest.converter.ApiToDomain;
import com.petwal.rest.converter.DomainToApi;
import com.petwal.rest.model.ApiOrder;
import com.petwal.rest.model.request.ApiOrderRequest;
import com.petwal.rest.model.request.ApiPerformPickRequest;
import com.petwal.rest.model.request.ApiStartOrderRequest;
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

    public void createNewOrder(final ApiOrderRequest request) {
        orderService.createOrder(ApiToDomain.convert(request));
    }

    public void pickOrderItem(final ApiPerformPickRequest request) {
        orderService.pickOrderItem(request.getOrderId(), request.getPickId(), request.getDeviceId(), request.getAmount());
    }

    public void startNewOrder(final ApiStartOrderRequest request) {
        orderService.startRandomOrder(request.getDeviceId());
    }

    public void startSpecificOrder(final ApiStartOrderRequest request) {
        orderService.startSpecificOrder(request.getDeviceId(), request.getOrderId());
    }

}

package com.petwal.rest.controller;

import com.petwal.service.OrderService;
import com.petwal.service.model.Order;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "order")
public class OrderController {

    private final OrderService orderService;

    public OrderController(final OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping
    public ResponseEntity<Order> getOrder(@RequestParam final String orderId) {

        return orderService.getOrder(orderId)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/pick")
    public void pick(@RequestParam final String orderId, @RequestParam final String itemId, @RequestParam final int quantity) {

    }
}

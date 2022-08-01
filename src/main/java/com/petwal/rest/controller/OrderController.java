package com.petwal.rest.controller;

import com.petwal.rest.model.ApiOrder;
import com.petwal.rest.service.ApiOrderService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "order")
public class OrderController {

    private final ApiOrderService apiOrderService;

    public OrderController(final ApiOrderService apiOrderService) {
        this.apiOrderService = apiOrderService;
    }

    @GetMapping
    public ResponseEntity<ApiOrder> getOrder(@RequestParam final String orderId) {

        return apiOrderService.getOrder(orderId)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/pick")
    public void pick(@RequestParam final String orderId, @RequestParam final String itemId, @RequestParam final int quantity) {

    }
}

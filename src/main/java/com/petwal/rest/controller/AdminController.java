package com.petwal.rest.controller;

import com.petwal.rest.model.ApiOrder;
import com.petwal.rest.model.request.ApiOrderRequest;
import com.petwal.rest.service.ApiOrderService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executors;

@RestController
@RequestMapping(value = "admin")
public class AdminController {

    private final ApiOrderService apiOrderService;

    public AdminController(final ApiOrderService apiOrderService) {
        this.apiOrderService = apiOrderService;
    }

    @GetMapping("/order")
    public ResponseEntity<ApiOrder> getOrder(@RequestParam final String orderId) {

        return apiOrderService.getOrder(orderId)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/order")
    public ResponseEntity<Void> createOrder(@RequestBody final ApiOrderRequest orderRequest) {

        CompletableFuture.runAsync(() -> apiOrderService.createNewOrder(orderRequest), Executors.newSingleThreadExecutor());
        return ResponseEntity.ok().build();
    }
}

package com.petwal.rest.controller;

import com.petwal.rest.model.ApiOrder;
import com.petwal.rest.model.request.ApiPerformPickRequest;
import com.petwal.rest.model.request.ApiStartOrderRequest;
import com.petwal.rest.service.ApiOrderService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "picking")
public class PickingController {

    private final ApiOrderService apiOrderService;

    public PickingController(final ApiOrderService apiOrderService) {
        this.apiOrderService = apiOrderService;
    }

    @GetMapping
    public ResponseEntity<ApiOrder> getOrder(@RequestParam final String orderId) {

        return apiOrderService.getOrder(orderId)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/pick")
    public ResponseEntity<Void> pick(@RequestBody final ApiPerformPickRequest pickRequest) {

        apiOrderService.pickOrderItem(pickRequest);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/start-random")
    public ResponseEntity<Void> startNewOrder(@RequestBody final ApiStartOrderRequest startOrderRequest) {

        apiOrderService.startNewOrder(startOrderRequest);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/start-specific")
    public ResponseEntity<Void> startSpecificOrder(@RequestBody final ApiStartOrderRequest startOrderRequest) {

        apiOrderService.startSpecificOrder(startOrderRequest);
        return ResponseEntity.ok().build();
    }
}

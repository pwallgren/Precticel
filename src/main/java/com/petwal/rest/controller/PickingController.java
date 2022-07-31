package com.petwal.rest.controller;

import com.petwal.service.PickingService;
import com.petwal.service.model.Order;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "picking")
public class PickingController {

    private final PickingService pickingService;

    public PickingController(final PickingService pickingService) {
        this.pickingService = pickingService;
    }

    @GetMapping
    public ResponseEntity<Order> getOrder(@RequestParam final String orderId) {

        return pickingService.getOrder(orderId)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
}

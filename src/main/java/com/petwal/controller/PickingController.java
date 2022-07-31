package com.petwal.controller;

import com.petwal.service.PickingService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "picking")
public class PickingController {

    private PickingService pickingService;

    public PickingController(final PickingService pickingService) {
        this.pickingService = pickingService;
    }

    @GetMapping
    public String getOrder(@RequestParam final String orderId) {

        return pickingService.getOrder(orderId).toString();
    }
}

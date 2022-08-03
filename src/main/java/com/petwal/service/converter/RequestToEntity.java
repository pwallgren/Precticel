package com.petwal.service.converter;

import com.petwal.repository.model.ItemEntity;
import com.petwal.repository.model.OrderEntity;
import com.petwal.repository.model.PickEntity;
import com.petwal.service.model.request.OrderRequest;
import com.petwal.service.model.request.PickRequest;

import java.time.Instant;
import java.util.List;
import java.util.stream.Collectors;

import static java.lang.Boolean.FALSE;

public class RequestToEntity {

    public static OrderEntity convert(final OrderRequest orderRequest) {

        return OrderEntity.builder()
                .id(orderRequest.getId())
                .created(Instant.now())
                .done(FALSE)
                .deviceId(orderRequest.getDeviceId())
                .picks(convert(orderRequest.getPicks()))
                .build();
    }

    public static List<PickEntity> convert(final List<PickRequest> pickRequests) {

        return pickRequests.stream()
                .map(RequestToEntity::convert)
                .collect(Collectors.toList());
    }

    public static PickEntity convert(final PickRequest pickRequest) {

        return PickEntity.builder()
                .id(pickRequest.getId())
                .picked(0)
                .done(FALSE)
                .quantity(pickRequest.getQuantity())
                .item(ItemEntity.builder().id(pickRequest.getItemId()).build())
                .build();
    }
}

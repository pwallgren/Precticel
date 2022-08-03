package com.petwal.rest.converter;

import com.petwal.rest.model.request.ApiOrderRequest;
import com.petwal.rest.model.request.ApiPickRequest;
import com.petwal.service.model.request.OrderRequest;
import com.petwal.service.model.request.PickRequest;

import java.util.List;
import java.util.stream.Collectors;

public class ApiToDomain {

    public static OrderRequest convert(final ApiOrderRequest apiRequest) {

        return OrderRequest.builder()
                .id(apiRequest.getId())
                .deviceId(apiRequest.getDeviceId())
                .picks(convert(apiRequest.getPicks()))
                .build();
    }

    public static List<PickRequest> convert(final List<ApiPickRequest> apiRequests) {

        return apiRequests.stream()
                .map(ApiToDomain::convert)
                .collect(Collectors.toList());
    }

    public static PickRequest convert(final ApiPickRequest apiRequest) {

        return PickRequest.builder()
                .id(apiRequest.getId())
                .itemId(apiRequest.getItemId())
                .quantity(apiRequest.getQuantity())
                .build();
    }
}

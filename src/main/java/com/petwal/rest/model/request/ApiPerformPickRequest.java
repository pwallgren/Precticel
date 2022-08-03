package com.petwal.rest.model.request;

import java.util.Objects;

public class ApiPerformPickRequest {

    private String orderId;
    private String pickId;
    private String deviceId;
    private Integer amount;

    private ApiPerformPickRequest() {
    }

    public String getOrderId() {
        return orderId;
    }

    public String getPickId() {
        return pickId;
    }

    public String getDeviceId() {
        return deviceId;
    }

    public Integer getAmount() {
        return amount;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final ApiPerformPickRequest that = (ApiPerformPickRequest) o;
        return Objects.equals(orderId, that.orderId) && Objects.equals(pickId, that.pickId) && Objects.equals(deviceId, that.deviceId) && Objects.equals(amount, that.amount);
    }

    @Override
    public int hashCode() {
        return Objects.hash(orderId, pickId, deviceId, amount);
    }

    @Override
    public String toString() {
        return "ApiOrderRequest{" +
                "orderId='" + orderId + '\'' +
                ", pickId='" + pickId + '\'' +
                ", deviceId='" + deviceId + '\'' +
                ", amount=" + amount +
                '}';
    }
}

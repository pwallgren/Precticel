package com.petwal.rest.model.request;

import java.io.Serializable;
import java.util.Objects;

public class ApiStartOrderRequest implements Serializable {

    private String deviceId;
    private String orderId;

    private ApiStartOrderRequest() {
    }

    public String getDeviceId() {
        return deviceId;
    }

    private void setDeviceId(final String deviceId) {
        this.deviceId = deviceId;
    }

    public String getOrderId() {
        return orderId;
    }

    private void setOrderId(final String orderId) {
        this.orderId = orderId;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final ApiStartOrderRequest that = (ApiStartOrderRequest) o;
        return Objects.equals(deviceId, that.deviceId) && Objects.equals(orderId, that.orderId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(deviceId, orderId);
    }

    @Override
    public String toString() {
        return "ApiDeviceRequest{" +
                "deviceId='" + deviceId + '\'' +
                ", orderId='" + orderId + '\'' +
                '}';
    }
}

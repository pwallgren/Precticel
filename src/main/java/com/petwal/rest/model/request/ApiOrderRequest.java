package com.petwal.rest.model.request;

import java.io.Serializable;
import java.util.Objects;

public class ApiOrderRequest implements Serializable {

    private String orderId;
    private String pickId;
    private String deviceId;
    private Integer amount;

    private ApiOrderRequest() {
    }

    public String getOrderId() {
        return orderId;
    }

    private void setOrderId(final String orderId) {
        this.orderId = orderId;
    }

    public String getPickId() {
        return pickId;
    }

    private void setPickId(final String pickId) {
        this.pickId = pickId;
    }

    public String getDeviceId() {
        return deviceId;
    }

    private void setDeviceId(final String deviceId) {
        this.deviceId = deviceId;
    }

    public Integer getAmount() {
        return amount;
    }

    private void setAmount(final Integer amount) {
        this.amount = amount;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final ApiOrderRequest that = (ApiOrderRequest) o;
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

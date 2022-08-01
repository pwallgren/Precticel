package com.petwal.rest.model.request;

import java.io.Serializable;
import java.util.Objects;

public class ApiDeviceRequest implements Serializable {

    private String deviceId;

    private ApiDeviceRequest() {
    }

    public String getDeviceId() {
        return deviceId;
    }

    private void setDeviceId(final String deviceId) {
        this.deviceId = deviceId;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final ApiDeviceRequest that = (ApiDeviceRequest) o;
        return Objects.equals(deviceId, that.deviceId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(deviceId);
    }

    @Override
    public String toString() {
        return "ApiDeviceRequest{" +
                "deviceId='" + deviceId + '\'' +
                '}';
    }
}

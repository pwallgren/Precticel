package com.petwal.rest.model.request;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

public class ApiOrderRequest implements Serializable {

    private String id;
    private List<ApiPickRequest> picks;
    private String deviceId;

    private ApiOrderRequest() {
    }

    public String getId() {
        return id;
    }

    public List<ApiPickRequest> getPicks() {
        return picks;
    }


    public String getDeviceId() {
        return deviceId;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final ApiOrderRequest that = (ApiOrderRequest) o;
        return Objects.equals(id, that.id) && Objects.equals(picks, that.picks) && Objects.equals(deviceId, that.deviceId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, picks, deviceId);
    }

    @Override
    public String toString() {
        return "ApiOrderRequest{" +
                "id='" + id + '\'' +
                ", picks=" + picks +
                ", deviceId='" + deviceId + '\'' +
                '}';
    }
}

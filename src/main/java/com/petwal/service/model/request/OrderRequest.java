package com.petwal.service.model.request;

import java.util.List;
import java.util.Objects;

import static com.petwal.util.Validation.checkNotEmpty;
import static com.petwal.util.Validation.checkNotNull;

public class OrderRequest {

    private String id;
    private List<PickRequest> picks;
    private String deviceId;

    private OrderRequest() {
    }

    private OrderRequest(final Builder builder) {
        id = checkNotNull(builder.id, "id");
        picks = checkNotEmpty(builder.picks, "picks");
        deviceId = builder.deviceId;
    }

    public String getId() {
        return id;
    }

    public List<PickRequest> getPicks() {
        return picks;
    }

    public String getDeviceId() {
        return deviceId;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static final class Builder {
        private String id;
        private List<PickRequest> picks;
        private String deviceId;

        private Builder() {
        }

        public Builder id(final String id) {
            this.id = id;
            return this;
        }

        public Builder picks(final List<PickRequest> picks) {
            this.picks = picks;
            return this;
        }

        public Builder deviceId(final String deviceId) {
            this.deviceId = deviceId;
            return this;
        }

        public OrderRequest build() {
            return new OrderRequest(this);
        }
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final OrderRequest that = (OrderRequest) o;
        return Objects.equals(id, that.id) && Objects.equals(picks, that.picks) && Objects.equals(deviceId, that.deviceId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, picks, deviceId);
    }

    @Override
    public String toString() {
        return "OrderRequest{" +
                "id='" + id + '\'' +
                ", picks=" + picks +
                ", deviceId='" + deviceId + '\'' +
                '}';
    }
}

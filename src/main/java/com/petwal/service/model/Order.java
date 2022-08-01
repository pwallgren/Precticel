package com.petwal.service.model;

import java.time.Instant;
import java.util.List;
import java.util.Objects;

import static com.petwal.util.Validation.checkNotEmpty;
import static com.petwal.util.Validation.checkNotNull;

public class Order {

    private String id;
    private Instant created;
    private Instant started;
    private List<Pick> picks;
    private Boolean done;
    private String deviceId;

    private Order() {
    }

    private Order(final Builder builder) {
        id = checkNotNull(builder.id, "id");
        created = checkNotNull(builder.created, "created");
        started = checkNotNull(builder.started, "started");
        picks = checkNotEmpty(builder.picks, "picks");
        done = checkNotNull(builder.done, "done");
        deviceId = checkNotNull(builder.deviceId, "deviceId");
    }

    public String getId() {
        return id;
    }

    public Instant getCreated() {
        return created;
    }

    public Instant getStarted() {
        return started;
    }

    public List<Pick> getPicks() {
        return picks;
    }

    public Boolean getDone() {
        return done;
    }

    public String getDeviceId() {
        return deviceId;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static final class Builder {
        private String id;
        private Instant created;
        private Instant started;
        private List<Pick> picks;
        private Boolean done;
        private String deviceId;

        private Builder() {
        }

        public Builder id(final String id) {
            this.id = id;
            return this;
        }

        public Builder created(final Instant created) {
            this.created = created;
            return this;
        }

        public Builder started(final Instant started) {
            this.started = started;
            return this;
        }

        public Builder picks(final List<Pick> picks) {
            this.picks = picks;
            return this;
        }

        public Builder done(final Boolean done) {
            this.done = done;
            return this;
        }

        public Builder deviceId(final String deviceId) {
            this.deviceId = deviceId;
            return this;
        }

        public Order build() {
            return new Order(this);
        }
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final Order order = (Order) o;
        return Objects.equals(id, order.id) && Objects.equals(created, order.created) && Objects.equals(started, order.started) && Objects.equals(picks, order.picks) && Objects.equals(done, order.done) && Objects.equals(deviceId, order.deviceId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, created, started, picks, done, deviceId);
    }

    @Override
    public String toString() {
        return "Order{" +
                "id='" + id + '\'' +
                ", created=" + created +
                ", started=" + started +
                ", picks=" + picks +
                ", done=" + done +
                ", deviceId='" + deviceId + '\'' +
                '}';
    }
}

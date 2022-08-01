package com.petwal.rest.model;

import java.time.Instant;
import java.util.List;
import java.util.Objects;

import static com.petwal.util.Validation.checkNotEmpty;
import static com.petwal.util.Validation.checkNotNull;

public class ApiOrder {

    private String id;
    private Instant created;
    private Instant started;
    private List<ApiPick> picks;
    private Boolean done;
    private String deviceId;

    private ApiOrder() {
    }

    private ApiOrder(final Builder builder) {
        id = checkNotNull(builder.id, "id");
        created = checkNotNull(builder.created, "created");
        started = checkNotNull(builder.started, "started");
        picks = checkNotEmpty(builder.picks, "picks");
        done = checkNotNull(builder.done, "done");
    }

    public String getId() {
        return id;
    }

    private void setId(final String id) {
        this.id = id;
    }

    public Instant getCreated() {
        return created;
    }

    private void setCreated(final Instant created) {
        this.created = created;
    }

    public Instant getStarted() {
        return started;
    }

    private void setStarted(final Instant started) {
        this.started = started;
    }

    public List<ApiPick> getPicks() {
        return picks;
    }

    private void setPicks(final List<ApiPick> picks) {
        this.picks = picks;
    }

    public Boolean getDone() {
        return done;
    }

    private void setDone(final Boolean done) {
        this.done = done;
    }

    public String getDeviceId() {
        return deviceId;
    }

    private void setDeviceId(final String deviceId) {
        this.deviceId = deviceId;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static final class Builder {
        private String id;
        private Instant created;
        private Instant started;
        private List<ApiPick> picks;
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

        public Builder picks(final List<ApiPick> picks) {
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

        public ApiOrder build() {
            return new ApiOrder(this);
        }
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final ApiOrder apiOrder = (ApiOrder) o;
        return Objects.equals(id, apiOrder.id) && Objects.equals(created, apiOrder.created) && Objects.equals(started, apiOrder.started) && Objects.equals(picks, apiOrder.picks) && Objects.equals(done, apiOrder.done) && Objects.equals(deviceId, apiOrder.deviceId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, created, started, picks, done, deviceId);
    }

    @Override
    public String toString() {
        return "ApiOrder{" +
                "id='" + id + '\'' +
                ", created=" + created +
                ", started=" + started +
                ", picks=" + picks +
                ", done=" + done +
                ", deviceId='" + deviceId + '\'' +
                '}';
    }
}

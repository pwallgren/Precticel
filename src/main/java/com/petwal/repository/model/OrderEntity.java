package com.petwal.repository.model;

import com.sun.istack.NotNull;

import javax.persistence.*;
import java.time.Instant;
import java.util.List;
import java.util.Objects;

@Entity
public class OrderEntity {

    @Id
    @NotNull
    private String id;
    @NotNull
    private Instant created;
    private Instant started;
    @JoinColumn(name = "order_id", referencedColumnName = "id")
    @OneToMany(fetch = FetchType.EAGER)
    private List<PickEntity> picks;
    @NotNull
    private Boolean done;
    private String deviceId;

    public OrderEntity() {
    }

    public OrderEntity(final Builder builder) {
        this.id = builder.id;
        this.created = builder.created;
        this.started = builder.started;
        this.picks = builder.picks;
        this.done = builder.done;
        this.deviceId = builder.deviceId;
    }

    public String getId() {
        return id;
    }

    public void setId(final String id) {
        this.id = id;
    }

    public Instant getCreated() {
        return created;
    }

    public void setCreated(final Instant created) {
        this.created = created;
    }

    public Instant getStarted() {
        return started;
    }

    public void setStarted(final Instant started) {
        this.started = started;
    }

    public List<PickEntity> getPicks() {
        return picks;
    }

    public void setPicks(final List<PickEntity> picks) {
        this.picks = picks;
    }

    public Boolean getDone() {
        return done;
    }

    public void setDone(final Boolean done) {
        this.done = done;
    }

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(final String deviceId) {
        this.deviceId = deviceId;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static final class Builder {
        private String id;
        private Instant created;
        private Instant started;
        private List<PickEntity> picks;
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

        public Builder picks(final List<PickEntity> picks) {
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

        public OrderEntity build() {
            return new OrderEntity(this);
        }
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final OrderEntity that = (OrderEntity) o;
        return Objects.equals(id, that.id) && Objects.equals(created, that.created) && Objects.equals(started, that.started) && Objects.equals(picks, that.picks) && Objects.equals(done, that.done) && Objects.equals(deviceId, that.deviceId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, created, started, picks, done, deviceId);
    }

    @Override
    public String toString() {
        return "OrderEntity{" +
                "id='" + id + '\'' +
                ", created=" + created +
                ", started=" + started +
                ", picks=" + picks +
                ", done=" + done +
                ", deviceId='" + deviceId + '\'' +
                '}';
    }
}

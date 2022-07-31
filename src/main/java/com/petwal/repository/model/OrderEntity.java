package com.petwal.repository.model;

import javax.persistence.*;
import java.time.Instant;
import java.util.List;
import java.util.Objects;

import static com.petwal.util.Validation.checkNotNull;

@Entity
public class OrderEntity {

    @Id
    private String id;
    private Instant created;
    private Instant started;
    @JoinColumn(name = "order_id", referencedColumnName = "id")
    @OneToMany(fetch = FetchType.EAGER)
    private List<PickEntity> picks;
    private Integer nextPick;
    private Boolean done;

    public OrderEntity() {
    }

    public OrderEntity(final String id, final Instant created, final Instant started, final List<PickEntity> picks, final Integer nextPick, final Boolean done) {
        this.id = checkNotNull(id, "id");
        this.created = checkNotNull(created, "created");
        this.started = checkNotNull(started, "started");
        this.picks = checkNotNull(picks, "pics");
        this.nextPick = checkNotNull(nextPick, "nextPick");
        this.done = checkNotNull(done, "done");
    }

    private OrderEntity(final Builder builder) {
        setId(builder.id);
        setCreated(builder.created);
        setStarted(builder.started);
        setPicks(builder.picks);
        setNextPick(builder.nextPick);
        setDone(builder.done);
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

    public List<PickEntity> getPicks() {
        return picks;
    }

    private void setPicks(final List<PickEntity> picks) {
        this.picks = picks;
    }

    public Integer getNextPick() {
        return nextPick;
    }

    private void setNextPick(final Integer nextPick) {
        this.nextPick = nextPick;
    }

    public Boolean getDone() {
        return done;
    }

    private void setDone(final Boolean done) {
        this.done = done;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static final class Builder {
        private String id;
        private Instant created;
        private Instant started;
        private List<PickEntity> picks;
        private Integer nextPick;
        private Boolean done;

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

        public Builder nextPick(final Integer nextPick) {
            this.nextPick = nextPick;
            return this;
        }

        public Builder done(final Boolean done) {
            this.done = done;
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
        return Objects.equals(id, that.id) && Objects.equals(created, that.created) && Objects.equals(started, that.started) && Objects.equals(picks, that.picks) && Objects.equals(nextPick, that.nextPick) && Objects.equals(done, that.done);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, created, started, picks, nextPick, done);
    }

    @Override
    public String toString() {
        return "OrderEntity{" +
                "id='" + id + '\'' +
                ", created=" + created +
                ", started=" + started +
                ", picks=" + picks +
                ", nextPick=" + nextPick +
                ", done=" + done +
                '}';
    }
}

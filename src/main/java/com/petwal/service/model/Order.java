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
    private Integer nextPick;
    private Boolean done;

    private Order() {
    }

    private Order(final Builder builder) {
        id = checkNotNull(builder.id, "id");
        created = checkNotNull(builder.created, "created");
        started = checkNotNull(builder.started, "started");
        picks = checkNotEmpty(builder.picks, "picks");
        nextPick = checkNotNull(builder.nextPick, "nextPick");
        done = checkNotNull(builder.done, "done");
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

    public Integer getNextPick() {
        return nextPick;
    }

    public Boolean getDone() {
        return done;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static final class Builder {
        private String id;
        private Instant created;
        private Instant started;
        private List<Pick> picks;
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

        public Builder picks(final List<Pick> picks) {
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

        public Order build() {
            return new Order(this);
        }
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final Order order = (Order) o;
        return Objects.equals(id, order.id) && Objects.equals(created, order.created) && Objects.equals(started, order.started) && Objects.equals(picks, order.picks) && Objects.equals(nextPick, order.nextPick) && Objects.equals(done, order.done);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, created, started, picks, nextPick, done);
    }

    @Override
    public String toString() {
        return "Order{" +
                "id='" + id + '\'' +
                ", created=" + created +
                ", started=" + started +
                ", picks=" + picks +
                ", nextPick=" + nextPick +
                ", done=" + done +
                '}';
    }
}

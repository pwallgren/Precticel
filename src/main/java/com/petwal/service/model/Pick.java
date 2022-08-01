package com.petwal.service.model;

import java.util.Objects;

import static com.petwal.util.Validation.checkNotNull;

public class Pick {

    private String id;
    private Item item;
    private Integer quantity;
    private Integer picked;
    private Boolean done;

    private Pick() {
    }

    private Pick(final Builder builder) {
        id = checkNotNull(builder.id, "id");
        item = checkNotNull(builder.item, "item");
        quantity = checkNotNull(builder.quantity, "quantity");
        picked = checkNotNull(builder.picked, "picked");
        done = checkNotNull(builder.done, "done");
    }

    public String getId() {
        return id;
    }

    public Item getItem() {
        return item;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public Integer getPicked() {
        return picked;
    }

    public Boolean getDone() {
        return done;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static final class Builder {
        private String id;
        private Item item;
        private Integer quantity;
        private Integer picked;
        private Boolean done;

        private Builder() {
        }

        public Builder id(final String id) {
            this.id = id;
            return this;
        }

        public Builder item(final Item item) {
            this.item = item;
            return this;
        }

        public Builder quantity(final Integer quantity) {
            this.quantity = quantity;
            return this;
        }

        public Builder picked(final Integer picked) {
            this.picked = picked;
            return this;
        }

        public Builder done(final Boolean done) {
            this.done = done;
            return this;
        }

        public Pick build() {
            return new Pick(this);
        }
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final Pick pick = (Pick) o;
        return Objects.equals(id, pick.id) && Objects.equals(item, pick.item) && Objects.equals(quantity, pick.quantity) && Objects.equals(picked, pick.picked) && Objects.equals(done, pick.done);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, item, quantity, picked, done);
    }

    @Override
    public String toString() {
        return "Pick{" +
                "id=" + id +
                ", item=" + item +
                ", quantity=" + quantity +
                ", picked=" + picked +
                ", done=" + done +
                '}';
    }
}

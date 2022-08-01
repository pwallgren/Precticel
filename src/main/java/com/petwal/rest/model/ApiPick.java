package com.petwal.rest.model;

import java.util.Objects;

import static com.petwal.util.Validation.checkNotNull;

public class ApiPick {

    private String id;
    private ApiItem item;
    private Integer quantity;
    private Integer picked;
    private Boolean done;

    private ApiPick() {
    }

    private ApiPick(final Builder builder) {
        this.id = checkNotNull(builder.id, "id");
        this.item = checkNotNull(builder.item, "item");
        this.quantity = checkNotNull(builder.quantity, "quantity");
        this.picked = checkNotNull(builder.picked, "picked");
        this.done = checkNotNull(builder.done, "done");
    }

    public String getId() {
        return id;
    }

    private void setId(final String id) {
        this.id = id;
    }

    public ApiItem getItem() {
        return item;
    }

    private void setItem(final ApiItem item) {
        this.item = item;
    }

    public int getQuantity() {
        return quantity;
    }

    private void setQuantity(final int quantity) {
        this.quantity = quantity;
    }

    public int getPicked() {
        return picked;
    }

    private void setPicked(final int picked) {
        this.picked = picked;
    }

    public boolean isDone() {
        return done;
    }

    private void setDone(final boolean done) {
        this.done = done;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static final class Builder {
        private String id;
        private ApiItem item;
        private Integer quantity;
        private Integer picked;
        private Boolean done;

        private Builder() {
        }

        public Builder id(final String id) {
            this.id = id;
            return this;
        }

        public Builder item(final ApiItem item) {
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

        public ApiPick build() {
            return new ApiPick(this);
        }
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final ApiPick apiPick = (ApiPick) o;
        return Objects.equals(id, apiPick.id) && Objects.equals(item, apiPick.item) && Objects.equals(quantity, apiPick.quantity) && Objects.equals(picked, apiPick.picked) && Objects.equals(done, apiPick.done);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, item, quantity, picked, done);
    }

    @Override
    public String toString() {
        return "ApiPick{" +
                "id='" + id + '\'' +
                ", item=" + item +
                ", quantity=" + quantity +
                ", picked=" + picked +
                ", done=" + done +
                '}';
    }
}

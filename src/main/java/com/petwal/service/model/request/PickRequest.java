package com.petwal.service.model.request;

import java.util.Objects;

import static com.petwal.util.Validation.checkNotNull;

public class PickRequest {

    private String id;
    private String itemId;
    private Integer quantity;

    public PickRequest() {
    }

    private PickRequest(final Builder builder) {
        id = checkNotNull(builder.id, "id");
        itemId = checkNotNull(builder.itemId, "itemId");
        quantity = checkNotNull(builder.quantity, "quantity");
    }

    public String getId() {
        return id;
    }

    public String getItemId() {
        return itemId;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static final class Builder {
        private String id;
        private String itemId;
        private Integer quantity;

        private Builder() {
        }

        public Builder id(final String id) {
            this.id = id;
            return this;
        }

        public Builder itemId(final String itemId) {
            this.itemId = itemId;
            return this;
        }

        public Builder quantity(final Integer quantity) {
            this.quantity = quantity;
            return this;
        }

        public PickRequest build() {
            return new PickRequest(this);
        }
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final PickRequest that = (PickRequest) o;
        return Objects.equals(id, that.id) && Objects.equals(itemId, that.itemId) && Objects.equals(quantity, that.quantity);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, itemId, quantity);
    }

    @Override
    public String toString() {
        return "PickRequest{" +
                "id='" + id + '\'' +
                ", itemId='" + itemId + '\'' +
                ", quantity=" + quantity +
                '}';
    }
}

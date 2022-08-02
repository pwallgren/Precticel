package com.petwal.rest.model;

import java.util.Objects;

import static com.petwal.util.Validation.checkNotNull;

public class ApiItem {

    private String id;
    private String name;
    private Integer quantity;
    private ApiItemType itemType;

    private ApiItem() {
    }

    private ApiItem(final Builder builder) {
        this.id = checkNotNull(builder.id, "id");
        this.name = checkNotNull(builder.name, "name");
        this.quantity = checkNotNull(builder.quantity, "quantity");
        this.itemType = checkNotNull(builder.itemType, "itemType");
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public ApiItemType getItemType() {
        return itemType;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static final class Builder {
        private String id;
        private String name;
        private Integer quantity;
        private ApiItemType itemType;

        private Builder() {
        }

        public Builder id(final String id) {
            this.id = id;
            return this;
        }

        public Builder name(final String name) {
            this.name = name;
            return this;
        }

        public Builder quantity(final Integer quantity) {
            this.quantity = quantity;
            return this;
        }

        public Builder itemType(final ApiItemType itemType) {
            this.itemType = itemType;
            return this;
        }

        public ApiItem build() {
            return new ApiItem(this);
        }
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final ApiItem apiItem = (ApiItem) o;
        return Objects.equals(id, apiItem.id) && Objects.equals(name, apiItem.name) && Objects.equals(quantity, apiItem.quantity) && Objects.equals(itemType, apiItem.itemType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, quantity, itemType);
    }

    @Override
    public String toString() {
        return "ApiItem{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", quantity=" + quantity +
                ", itemType=" + itemType +
                '}';
    }
}

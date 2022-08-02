package com.petwal.service.model;

import java.util.Objects;

import static com.petwal.util.Validation.checkNotNull;

public class Item {

    private String id;
    private String name;
    private Integer quantity;
    private ItemType itemType;

    private Item() {
    }

    private Item(final Builder builder) {
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

    public ItemType getItemType() {
        return itemType;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static final class Builder {
        private String id;
        private String name;
        private Integer quantity;
        private ItemType itemType;

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

        public Builder itemType(final ItemType itemType) {
            this.itemType = itemType;
            return this;
        }

        public Item build() {
            return new Item(this);
        }
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final Item item = (Item) o;
        return Objects.equals(id, item.id) && Objects.equals(name, item.name) && Objects.equals(quantity, item.quantity) && Objects.equals(itemType, item.itemType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, quantity, itemType);
    }

    @Override
    public String toString() {
        return "Item{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", quantity=" + quantity +
                ", itemType=" + itemType +
                '}';
    }
}

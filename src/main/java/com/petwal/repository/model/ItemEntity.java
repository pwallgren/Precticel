package com.petwal.repository.model;

import com.sun.istack.NotNull;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class ItemEntity {

    @Id
    @NotNull
    private String id;
    @NotNull
    private String name;
    @NotNull
    private Integer quantity;
    @JoinColumn(name = "item_type_id", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.EAGER)
    @NotNull
    private ItemTypeEntity itemType;


    private ItemEntity() {
    }

    private ItemEntity(final Builder builder) {
        this.id = builder.id;
        this.name = builder.name;
        this.itemType = builder.itemType;
    }

    public String getId() {
        return id;
    }

    public void setId(final String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public ItemTypeEntity getItemType() {
        return itemType;
    }

    public void setItemType(final ItemTypeEntity itemType) {
        this.itemType = itemType;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(final Integer quantity) {
        this.quantity = quantity;
    }

    public void decreaseQuantity(final int q) {
        if(q > 0 && this.quantity >= q) {
            this.quantity -= q;
        }
    }

    public static Builder builder() {
        return new Builder();
    }

    public static final class Builder {
        private String id;
        private String name;
        private Integer quantity;
        private ItemTypeEntity itemType;

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

        public Builder itemType(final ItemTypeEntity itemType) {
            this.itemType = itemType;
            return this;
        }

        public ItemEntity build() {
            return new ItemEntity(this);
        }
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final ItemEntity that = (ItemEntity) o;
        return Objects.equals(id, that.id) && Objects.equals(name, that.name) && Objects.equals(quantity, that.quantity) && Objects.equals(itemType, that.itemType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, quantity, itemType);
    }

    @Override
    public String toString() {
        return "ItemEntity{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", quantity=" + quantity +
                ", itemType=" + itemType +
                '}';
    }
}

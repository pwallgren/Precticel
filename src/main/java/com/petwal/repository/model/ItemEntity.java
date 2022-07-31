package com.petwal.repository.model;

import javax.persistence.*;
import java.util.Objects;

import static com.petwal.util.Validation.checkNotNull;

@Entity
public class ItemEntity {

    @Id
    private String id;
    private String name;
    @JoinColumn(name = "product_type_id", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.EAGER)
    private ItemTypeEntity itemType;


    private ItemEntity() {
    }

    private ItemEntity(final String id, final String name, final ItemTypeEntity itemType) {
        this.id = checkNotNull(id, "id");
        this.name = checkNotNull(name, "name");
        this.itemType = checkNotNull(itemType, "itemType");
    }

    private ItemEntity(final Builder builder) {
        setId(builder.id);
        setName(builder.name);
        setItemType(builder.itemType);
    }

    public String getId() {
        return id;
    }

    private void setId(final String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    private void setName(final String name) {
        this.name = name;
    }

    public ItemTypeEntity getItemType() {
        return itemType;
    }

    private void setItemType(final ItemTypeEntity itemType) {
        this.itemType = itemType;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static final class Builder {
        private String id;
        private String name;
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
        return Objects.equals(id, that.id) && Objects.equals(name, that.name) && Objects.equals(itemType, that.itemType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, itemType);
    }

    @Override
    public String toString() {
        return "ProductEntity{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", itemType=" + itemType +
                '}';
    }
}

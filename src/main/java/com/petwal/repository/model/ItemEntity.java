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
    private ItemTypeEntity productType;


    private ItemEntity() {
    }

    private ItemEntity(final String id, final String name, final ItemTypeEntity productType) {
        this.id = checkNotNull(id, "id");
        this.name = checkNotNull(name, "name");
        this.productType = checkNotNull(productType, "productType");
    }

    private ItemEntity(final Builder builder) {
        setId(builder.id);
        setName(builder.name);
        setProductType(builder.productType);
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

    public ItemTypeEntity getProductType() {
        return productType;
    }

    private void setProductType(final ItemTypeEntity productType) {
        this.productType = productType;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static final class Builder {
        private String id;
        private String name;
        private ItemTypeEntity productType;

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

        public Builder productType(final ItemTypeEntity productType) {
            this.productType = productType;
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
        return Objects.equals(id, that.id) && Objects.equals(name, that.name) && Objects.equals(productType, that.productType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, productType);
    }

    @Override
    public String toString() {
        return "ProductEntity{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", productType=" + productType +
                '}';
    }
}

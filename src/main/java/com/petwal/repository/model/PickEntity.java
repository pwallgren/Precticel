package com.petwal.repository.model;

import javax.persistence.*;

import java.util.Objects;

import static com.petwal.util.Validation.checkNotNull;

@Entity
public class PickEntity {

    @Id
    private String id;
    @JoinColumn()
    @OneToOne(fetch = FetchType.EAGER)
    private ItemEntity item;
    @JoinColumn()
    @OneToOne(fetch = FetchType.EAGER)
    private OrderEntity order;
    private Integer quantity;
    private Integer picked;
    private Boolean done;

    private PickEntity() {
    }

    private PickEntity(final Builder builder) {
        this.id = checkNotNull(builder.id, "pickId");
        this.item = checkNotNull(builder.item, "item");
        this.order = checkNotNull(builder.order, "order");
        this.quantity = checkNotNull(builder.quantity, "quantity");
        this.picked = checkNotNull(builder.picked, "picked");
        this.done = checkNotNull(builder.done, "done");
    }

    public String getId() {
        return id;
    }

    public void setId(final String id) {
        this.id = id;
    }

    public ItemEntity getItem() {
        return item;
    }

    public void setItem(final ItemEntity item) {
        this.item = item;
    }

    public OrderEntity getOrder() {
        return order;
    }

    public void setOrder(final OrderEntity order) {
        this.order = order;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(final Integer quantity) {
        this.quantity = quantity;
    }

    public Integer getPicked() {
        return picked;
    }

    public void setPicked(final Integer picked) {
        this.picked = picked;
    }

    public static Builder builder() {
        return new Builder();
    }

    public Boolean getDone() {
        return done;
    }

    public void setDone(final Boolean done) {
        this.done = done;
    }

    public static final class Builder {
        private String id;
        private ItemEntity item;
        private OrderEntity order;
        private Integer quantity;
        private Integer picked;
        private Boolean done;

        private Builder() {
        }

        public Builder id(final String id) {
            this.id = id;
            return this;
        }

        public Builder item(final ItemEntity item) {
            this.item = item;
            return this;
        }

        public Builder order(final OrderEntity order) {
            this.order = order;
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

        public PickEntity build() {
            return new PickEntity(this);
        }
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final PickEntity that = (PickEntity) o;
        return Objects.equals(id, that.id) && Objects.equals(item, that.item) && Objects.equals(order, that.order)
                && Objects.equals(quantity, that.quantity) && Objects.equals(picked, that.picked) && Objects.equals(done, that.done);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, item, order, quantity, picked, done);
    }

    @Override
    public String toString() {
        return "PickEntity{" +
                "id=" + id +
                ", item=" + item +
                ", order=" + order.getId() +
                ", quantity=" + quantity +
                ", picked=" + picked +
                ", done=" + done +
                '}';
    }
}

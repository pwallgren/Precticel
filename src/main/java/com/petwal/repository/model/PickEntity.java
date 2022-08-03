package com.petwal.repository.model;

import com.sun.istack.NotNull;

import javax.persistence.*;
import java.util.Objects;

import static java.lang.Boolean.TRUE;

@Entity
public class PickEntity {

    @Id
    @NotNull
    private String id;
    @JoinColumn()
    @OneToOne(fetch = FetchType.EAGER)
    @NotNull
    private ItemEntity item;
    @JoinColumn()
    @OneToOne(fetch = FetchType.EAGER)
    @NotNull
    private OrderEntity order;
    @NotNull
    private Integer quantity;
    @NotNull
    private Integer picked;
    @NotNull
    private Boolean done;

    private PickEntity() {
    }

    private PickEntity(final Builder builder) {
        this.id = builder.id;
        this.item = builder.item;
        this.order = builder.order;
        this.quantity = builder.quantity;
        this.picked = builder.picked;
        this.done = builder.done;
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

    public void makePick(final int amount) {

        final int pickAmountLeft = this.quantity - this.picked;
        if (amount > 0 && pickAmountLeft >= amount) {
            this.picked += amount;

            if (Objects.equals(this.picked, this.quantity)) {
                this.done = TRUE;
            }
        }
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

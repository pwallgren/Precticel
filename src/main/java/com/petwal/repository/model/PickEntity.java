package com.petwal.repository.model;

import javax.persistence.*;

import java.util.Objects;

import static com.petwal.util.Validation.checkNotNull;

@Entity
public class PickEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
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

    private PickEntity(final Long id, final ItemEntity item, final OrderEntity order, final Integer quantity, final Integer picked, final Boolean done) {
        this.id = checkNotNull(id, "pickId");
        this.item = checkNotNull(item, "item");
        this.order = checkNotNull(order, "order");
        this.quantity = checkNotNull(quantity, "quantity");
        this.picked = checkNotNull(picked, "picked");
        this.done = checkNotNull(done, "done");
    }

    private PickEntity(final Builder builder) {
        setId(builder.pickId);
        setItem(builder.item);
        setOrder(builder.order);
        setQuantity(builder.quantity);
        setPicked(builder.picked);
    }

    public Long getId() {
        return id;
    }

    private void setId(final Long id) {
        this.id = id;
    }

    public ItemEntity getItem() {
        return item;
    }

    private void setItem(final ItemEntity item) {
        this.item = item;
    }

    public OrderEntity getOrder() {
        return order;
    }

    private void setOrder(final OrderEntity order) {
        this.order = order;
    }

    public Integer getQuantity() {
        return quantity;
    }

    private void setQuantity(final Integer quantity) {
        this.quantity = quantity;
    }

    public Integer getPicked() {
        return picked;
    }

    private void setPicked(final Integer picked) {
        this.picked = picked;
    }

    public static Builder builder() {
        return new Builder();
    }

    public Boolean getDone() {
        return done;
    }

    private void setDone(final Boolean done) {
        this.done = done;
    }

    public static final class Builder {
        private Long pickId;
        private ItemEntity item;
        private OrderEntity order;
        private Integer quantity;
        private Integer picked;
        private Boolean done;

        private Builder() {
        }

        public Builder pickId(final Long pickId) {
            this.pickId = pickId;
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
        return Objects.equals(id, that.id) && Objects.equals(item, that.item) && Objects.equals(order, that.order) && Objects.equals(quantity, that.quantity) && Objects.equals(picked, that.picked) && Objects.equals(done, that.done);
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

package com.petwal.rest.model.request;

import java.io.Serializable;
import java.util.Objects;

public class ApiPickRequest implements Serializable {

    private String id;
    private String itemId;
    private Integer quantity;

    private ApiPickRequest() {
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

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final ApiPickRequest that = (ApiPickRequest) o;
        return Objects.equals(id, that.id) && Objects.equals(itemId, that.itemId) && Objects.equals(quantity, that.quantity);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, itemId, quantity);
    }

    @Override
    public String toString() {
        return "ApiPickRequest{" +
                "id='" + id + '\'' +
                ", itemId='" + itemId + '\'' +
                ", quantity=" + quantity +
                '}';
    }
}

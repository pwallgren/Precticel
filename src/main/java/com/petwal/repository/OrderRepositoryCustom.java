package com.petwal.repository;

public interface OrderRepositoryCustom {

    void pickOrderItem(final String orderId, final String pickId, final int amountToPick);
}

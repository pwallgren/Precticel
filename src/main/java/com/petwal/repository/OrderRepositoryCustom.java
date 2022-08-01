package com.petwal.repository;

public interface OrderRepositoryCustom {

    void pickOrderItem(final String orderId, final String pickId, final String deviceId, final int amountToPick);

    void startRandomOrder(final String deviceId);

    void startSpecificOrder(final String deviceId, final String orderId);
}

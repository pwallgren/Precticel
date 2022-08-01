package com.petwal.repository.impl;

import com.petwal.repository.OrderRepositoryCustom;
import com.petwal.repository.model.OrderEntity;
import com.petwal.repository.model.PickEntity;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import static java.lang.Boolean.TRUE;

public class OrderRepositoryImpl implements OrderRepositoryCustom {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    @Transactional
    public void pickOrderItem(final String orderId, final String pickId, final String deviceId, final int amountToPick) {

        Optional.ofNullable(entityManager.find(OrderEntity.class, orderId))
                .filter(order -> order.getDeviceId().equals(deviceId))
                .ifPresent(orderEntity -> pickItemFromOrder(orderEntity, pickId, amountToPick));
    }

    @Override
    @Transactional
    public void startRandomOrder(final String deviceId) {

        final List<OrderEntity> resultList = getAllInactiveOrders();

        if (!resultList.isEmpty()) {

            final int randomPos = (int) (Math.random() * resultList.size());
            final OrderEntity orderEntity = resultList.get(randomPos);
            orderEntity.setDeviceId(deviceId);
            entityManager.persist(orderEntity);
        }
    }

    @Override
    @Transactional
    public void startSpecificOrder(final String deviceId, final String orderId) {

        final OrderEntity orderEntity = entityManager.find(OrderEntity.class, orderId);
        orderEntity.setDeviceId(deviceId);
        entityManager.persist(orderEntity);
    }

    private List<OrderEntity> getAllInactiveOrders() {

        final TypedQuery<OrderEntity> query = entityManager.createQuery("SELECT order FROM OrderEntity order WHERE order.deviceId is null", OrderEntity.class);
        final List<OrderEntity> resultList = query.getResultList();
        return resultList;
    }

    private void pickItemFromOrder(final OrderEntity orderEntity, final String pickId, final int amountToPick) {

        orderEntity.getPicks().stream()
                .filter(pick -> !pick.getDone())
                .filter(pick -> Objects.equals(pick.getId(), pickId))
                .filter(pick -> isValidAmount(pick, amountToPick))
                .findFirst()
                .ifPresent(pickEntity -> performPick(orderEntity, pickEntity, amountToPick));
    }

    private void performPick(final OrderEntity orderEntity, final PickEntity pick, final int amountToPick) {

        pick.setPicked(pick.getPicked() + amountToPick);

        if (Objects.equals(pick.getPicked(), pick.getQuantity())) {
            pick.setDone(TRUE);
        }

        if (allPicksDone(orderEntity)) {
            orderEntity.setDone(TRUE);
        }

        entityManager.persist(orderEntity);
    }

    private boolean allPicksDone(final OrderEntity order) {

        for (PickEntity p : order.getPicks()) {
            if (p.getDone() != TRUE) {
                return false;
            }
        }

        return true;
    }

    private boolean isValidAmount(final PickEntity pick, final int amountToPick) {

        final int amountLeft = pick.getQuantity() - pick.getPicked();
        return amountToPick > 0 && amountLeft >= amountToPick;
    }

}

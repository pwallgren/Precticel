package com.petwal.repository.impl;

import com.petwal.repository.OrderRepositoryCustom;
import com.petwal.repository.model.OrderEntity;
import com.petwal.repository.model.PickEntity;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

import static java.lang.Boolean.TRUE;

public class OrderRepositoryImpl implements OrderRepositoryCustom {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    @Transactional
    public void pickOrderItem(final String orderId, final String pickId, final int amountToPick) {

        Optional.ofNullable(entityManager.find(OrderEntity.class, orderId))
                        .ifPresent(orderEntity -> pickItemFromOrder(orderEntity, pickId, amountToPick));
    }

    private void pickItemFromOrder(final OrderEntity orderEntity, final String pickId, final int amountToPick) {

        final Map<String, PickEntity> orderPicksLeft = orderEntity.getPicks().stream()
                .filter(pick -> !pick.getDone())
                .collect(Collectors.toMap(PickEntity::getId, o -> o));

        if(orderPicksLeft.containsKey(pickId) && !orderEntity.getDone()) {

            final PickEntity pick = orderPicksLeft.get(pickId);

            pick.setPicked(pick.getPicked() + amountToPick);

            if(Objects.equals(pick.getPicked(), pick.getQuantity())) {
                pick.setDone(TRUE);
            }

            if(allPicksDone(orderEntity)) {
                orderEntity.setDone(TRUE);
            }

            entityManager.persist(orderEntity);
        }
    }

    private boolean allPicksDone(final OrderEntity order) {

        for(PickEntity p : order.getPicks()){

            if(p.getDone() != TRUE){
                return false;
            }
        }

        return true;
    }


}
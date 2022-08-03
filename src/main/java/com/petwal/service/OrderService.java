package com.petwal.service;

import com.petwal.repository.OrderRepository;
import com.petwal.repository.PickRepository;
import com.petwal.repository.model.OrderEntity;
import com.petwal.repository.model.PickEntity;
import com.petwal.service.converter.EntityToDomain;
import com.petwal.service.converter.RequestToEntity;
import com.petwal.service.model.Order;
import com.petwal.service.model.request.OrderRequest;

import java.time.Instant;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import static java.lang.Boolean.TRUE;

public class OrderService {

    private final OrderRepository orderRepository;
    private final PickRepository pickRepository;

    public OrderService(final OrderRepository orderRepository, final PickRepository pickRepository) {
        this.orderRepository = orderRepository;
        this.pickRepository = pickRepository;
    }

    public Optional<Order> getOrder(final String orderId) {
        return orderRepository.findById(orderId)
                .map(EntityToDomain::convert);
    }

    public void createOrder(final OrderRequest orderRequest) {

        final OrderEntity orderEntity = RequestToEntity.convert(orderRequest);
        pickRepository.saveAll(orderEntity.getPicks());
        orderRepository.save(orderEntity);

    }

    public void pickOrderItem(final String orderId, final String pickId, final String deviceId, final int amount) {

        orderRepository.findById(orderId)
                .filter(order -> order.getDeviceId().equals(deviceId))
                .ifPresent(orderEntity -> performPick(orderEntity, pickId, amount));
    }

    public void startRandomOrder(final String deviceId) {

        final List<OrderEntity> resultList = getAllInactiveOrders();

        if (!resultList.isEmpty()) {

            final int randomPos = (int) (Math.random() * resultList.size());
            final OrderEntity orderEntity = resultList.get(randomPos);
            startOrder(orderEntity, deviceId);
        }
    }

    public void startSpecificOrder(final String deviceId, final String orderId) {

        orderRepository.findById(orderId)
                .ifPresent(order -> startOrder(order, deviceId));
    }

    private void startOrder(final OrderEntity orderEntity, final String deviceId) {

        orderEntity.setDeviceId(deviceId);
        orderEntity.setStarted(Instant.now());
        orderRepository.save(orderEntity);
    }

    private List<OrderEntity> getAllInactiveOrders() {

        return StreamSupport.stream(orderRepository.findAll().spliterator(), false)
                .filter(order -> order.getDeviceId() == null)
                .collect(Collectors.toList());
    }

    private void performPick(final OrderEntity orderEntity, final String pickId, final int amountToPick) {

        orderEntity.getPicks().stream()
                .filter(pick -> !pick.getDone())
                .filter(pick -> Objects.equals(pick.getId(), pickId))
                .filter(pick -> isValidAmount(pick, amountToPick))
                .findFirst()
                .ifPresent(pickEntity -> savePickedOrder(orderEntity, pickEntity, amountToPick));
    }

    private void savePickedOrder(final OrderEntity orderEntity, final PickEntity pick, final int amountToPick) {

        pick.makePick(amountToPick);
        pick.getItem().decreaseQuantity(amountToPick);

        if (allPicksDone(orderEntity)) {
            orderEntity.setDone(TRUE);
        }

        pickRepository.save(pick);
        orderRepository.save(orderEntity);
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

        final int pickAmountLeft = pick.getQuantity() - pick.getPicked();
        return amountToPick > 0 && pickAmountLeft >= amountToPick && pick.getItem().getQuantity() >= amountToPick;
    }
}

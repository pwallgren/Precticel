package com.petwal.service.converter;

import com.petwal.repository.model.ItemEntity;
import com.petwal.repository.model.ItemTypeEntity;
import com.petwal.repository.model.OrderEntity;
import com.petwal.repository.model.PickEntity;
import com.petwal.service.model.Item;
import com.petwal.service.model.ItemType;
import com.petwal.service.model.Order;
import com.petwal.service.model.Pick;

import java.util.List;
import java.util.stream.Collectors;

public class EntityToDomain {

    public static Order convert(final OrderEntity orderEntity) {
        return Order.builder()
                .id(orderEntity.getId())
                .picks(convert(orderEntity.getPicks()))
                .created(orderEntity.getCreated())
                .started(orderEntity.getStarted())
                .done(orderEntity.getDone())
                .deviceId(orderEntity.getDeviceId())
                .build();
    }

    public static Pick convert(final PickEntity pickEntity) {
        return Pick.builder()
                .id(pickEntity.getId())
                .quantity(pickEntity.getQuantity())
                .item(convert(pickEntity.getItem()))
                .done(pickEntity.getDone())
                .picked(pickEntity.getPicked())
                .build();
    }

    public static List<Pick> convert(final List<PickEntity> pickEntities) {
        return pickEntities.stream()
                .map(EntityToDomain::convert)
                .collect(Collectors.toList());
    }

    public static Item convert(final ItemEntity itemEntity) {
        return Item.builder()
                .id(itemEntity.getId())
                .name(itemEntity.getName())
                .quantity(itemEntity.getQuantity())
                .itemType(convert(itemEntity.getItemType()))
                .build();
    }

    public static ItemType convert(final ItemTypeEntity itemTypeEntity) {
        return ItemType.of(itemTypeEntity.getId(), itemTypeEntity.getName());
    }
}

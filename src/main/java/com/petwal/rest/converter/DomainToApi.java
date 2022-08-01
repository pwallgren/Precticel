package com.petwal.rest.converter;

import com.petwal.rest.model.ApiItem;
import com.petwal.rest.model.ApiItemType;
import com.petwal.rest.model.ApiOrder;
import com.petwal.rest.model.ApiPick;
import com.petwal.service.model.Item;
import com.petwal.service.model.ItemType;
import com.petwal.service.model.Order;
import com.petwal.service.model.Pick;

import java.util.List;
import java.util.stream.Collectors;

public class DomainToApi {

    public static ApiOrder convert(final Order order) {
        return ApiOrder.builder()
                .id(order.getId())
                .picks(convert(order.getPicks()))
                .created(order.getCreated())
                .started(order.getStarted())
                .done(order.getDone())
                .deviceId(order.getDeviceId())
                .build();
    }

    public static ApiPick convert(final Pick pick) {
        return ApiPick.builder()
                .id(pick.getId())
                .quantity(pick.getQuantity())
                .item(convert(pick.getItem()))
                .done(pick.getDone())
                .picked(pick.getPicked())
                .build();
    }

    public static List<ApiPick> convert(final List<Pick> picks) {
        return picks.stream()
                .map(DomainToApi::convert)
                .collect(Collectors.toList());
    }

    public static ApiItem convert(final Item item) {
        return ApiItem.builder()
                .id(item.getId())
                .name(item.getName())
                .itemType(convert(item.getItemType()))
                .build();
    }

    public static ApiItemType convert(final ItemType itemType) {
        return ApiItemType.of(itemType.getId(), itemType.getName());
    }
}

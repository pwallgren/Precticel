package com.petwal.service.model;

import java.util.Objects;

import static com.petwal.util.Validation.checkNotNull;

public class ItemType {

    private String id;
    private String name;

    private ItemType() {
    }


    private ItemType(final String id, final String name) {
        this.id = checkNotNull(id, "id");
        this.name = checkNotNull(name, "name");
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public static ItemType of(final String id, final String name) {
        return new ItemType(id, name);
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final ItemType itemType = (ItemType) o;
        return Objects.equals(id, itemType.id) && Objects.equals(name, itemType.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }

    @Override
    public String toString() {
        return "ItemType{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}

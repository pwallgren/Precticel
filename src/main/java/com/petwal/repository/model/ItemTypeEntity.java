package com.petwal.repository.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;

import static com.petwal.util.Validation.checkNotNull;

@Entity
public class ItemTypeEntity {

    @Id
    private String id;
    private String name;

    private ItemTypeEntity() {
    }

    private ItemTypeEntity(final String id, final String name) {
        this.id = checkNotNull(id, "id");
        this.name = checkNotNull(name, "name");
    }

    public String getId() {
        return id;
    }

    private void setId(final String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    private void setName(final String name) {
        this.name = name;
    }

    public static ItemTypeEntity of(final String id, final String name) {
        return new ItemTypeEntity(id, name);
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final ItemTypeEntity that = (ItemTypeEntity) o;
        return Objects.equals(id, that.id) && Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }

    @Override
    public String toString() {
        return "ProductTypeEntity{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}

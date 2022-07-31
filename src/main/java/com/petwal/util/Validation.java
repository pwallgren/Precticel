package com.petwal.util;

import java.util.Collection;
import java.util.Map;
import java.util.Objects;

public class Validation {

    public static <T> T checkNotNull(final T value, final String name) {
        return Objects.requireNonNull(value, name + " cannot be null");
    }

    public static <T extends Collection> T checkNotEmpty(final T collection, final String name) {
        if (checkNotNull(collection, name).isEmpty()) {
            throw new IllegalArgumentException(name + " cannot be empty");
        }

        return collection;
    }

    public static <K, V> Map<K, V> checkNotEmpty(final Map<K, V> map, final String name) {
        if (checkNotNull(map, name).isEmpty()) {
            throw new IllegalArgumentException(name + " cannot be empty");
        }

        return map;
    }

    public static String checkNotEmpty(final String string, final String name) {
        if (checkNotNull(string, name).isEmpty()) {
            throw new IllegalArgumentException(name + " cannot be empty");
        }

        return string;
    }
}

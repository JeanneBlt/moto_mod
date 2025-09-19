package com.pyloufass.motomod.entity.custom;

import java.util.Arrays;
import java.util.Comparator;

public enum MotoVariant {
    DEFAULT(0),
    ORCHID(1);

    private static final MotoVariant[] BY_ID = Arrays.stream(values()).sorted(Comparator.
            comparingInt(MotoVariant::getId)).toArray(MotoVariant[]::new);
    private final int id;

    MotoVariant(int id) {
        this.id = id;
    }

    public int getId() {
        return this.id;
    }

    public static MotoVariant byId(int id) {
        return BY_ID[id % BY_ID.length];
    }
}

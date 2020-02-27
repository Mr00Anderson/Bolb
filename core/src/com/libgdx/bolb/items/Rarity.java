package com.libgdx.bolb.items;

public enum Rarity {

    COMMON(1),
    UNCOMMON(2),
    RARE(3),
    EPIC(4),
    LEGENDARY(5),
    SET(6),
    MYTHICAL(7),
    FORBIDDEN(8);

    private final int level;


    Rarity(int level) {
        this.level = level;
    }

    public int getLevel() {
        return this.level;
    }

}

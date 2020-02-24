package com.libgdx.bolb.items;

public enum Rarity {

    COMMON(1),
    UNCOMMON(2),
    RARE(3),
    EPIC(4),
    LEGENDARY(5),
    MYTHICAL(6),
    FORBIDDEN(7),
    TITAN(8);

    int level;

    private Rarity(int level) {
        this.level = level;
    }

    public int getLevel() {
        return this.level;
    }

}

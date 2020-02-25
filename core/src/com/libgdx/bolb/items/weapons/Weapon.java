package com.libgdx.bolb.items.weapons;

import com.libgdx.bolb.items.Item;
import com.libgdx.bolb.items.ItemType;
import com.libgdx.bolb.items.Rarity;

public abstract class Weapon implements Item {
    private String name;
    private int damage;
    private String description;
    Rarity rarity;

    public Weapon(String name, int damage, String description, Rarity rarity){
        this.name = name;
        this.damage = damage;
        this.description = description;
        this.rarity = rarity;
    }

    public String getName(){ return name;}

    @Override
    public ItemType getType() {
        return null;
    }

    @Override
    public Rarity getRarity() { return rarity; }

    @Override
    public String getDescription() {return description;}

    public int getDamage(){return damage;}
}

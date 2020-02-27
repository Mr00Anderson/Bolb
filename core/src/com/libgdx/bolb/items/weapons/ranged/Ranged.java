package com.libgdx.bolb.items.weapons.ranged;

import com.libgdx.bolb.items.Item;
import com.libgdx.bolb.items.Rarity;
import com.libgdx.bolb.items.weapons.Weapon;

public class Ranged extends Weapon {
    public int range;
    public int maxammo;
    private String description;


    public Ranged(int range, int maxammo, float reloadspeed) {
        //super(name, damage, reloadspeed);
        this.range = range;
        this.maxammo = maxammo;
    }

    @Override
    public Rarity getRarity() {
        return Rarity.UNCOMMON;
    }

    @Override
    public String getDescription() {
        return super.getDescription();
    }

    @Override
    public int getDamage() {
        return super.getDamage();
    }

    public int GetRange() {
        return range;
    }

    public int GetMaxAmmo() {
        return maxammo;
    }

}

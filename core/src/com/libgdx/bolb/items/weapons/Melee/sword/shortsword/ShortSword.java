package com.libgdx.bolb.items.weapons.Melee.sword.shortsword;

public class ShortSword {

    //Distance travelled by sword
    public float jab;

    //Time it takes for sword to travel that distance
    public float jabspeed;

    public ShortSword(String name, int damage, float reloadspeed, float jab, float jabspeed) {
        //super(name, damage, reloadspeed);
        this.jab = jab;
        this.jabspeed = jabspeed;

    }

    public float getJab() { return jab; }
    public float getJabspeed() {
        return jabspeed;
    }

}

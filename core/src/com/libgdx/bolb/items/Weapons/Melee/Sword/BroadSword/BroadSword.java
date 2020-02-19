package com.libgdx.bolb.items.Weapons.Melee.Sword.BroadSword;

public class BroadSword {

    public float swing;
    public float swingspeed;

    public BroadSword(String name, int damage, float reloadspeed, float swing, float swingspeed) {
        //super(name, damage, reloadspeed);
        this.swing = swing;
        this.swingspeed = swingspeed;
    }

    public float getSwing() {
        return swing;
    }
    public float getSwingspeed() {
        return swingspeed;
    }
}

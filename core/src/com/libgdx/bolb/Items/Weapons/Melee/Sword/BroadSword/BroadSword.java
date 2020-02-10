package com.libgdx.bolb.Items.Weapons.Melee.Sword.BroadSword;

import com.libgdx.bolb.Items.Weapons.Melee.Sword.Sword;

public class BroadSword extends Sword {

    public float swing;
    public float swingspeed;

    public BroadSword(String name, int damage, float reloadspeed, float swing, float swingspeed) {
        super(name, damage, reloadspeed);
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

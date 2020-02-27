package com.libgdx.bolb.items.weapons.ranged.gun;

import com.libgdx.bolb.items.weapons.ranged.Ranged;

public class Gun extends Ranged {

    public Gun(String name, int damage, int range, int maxammo, float reloadspeed) {
        super(range, maxammo, reloadspeed);
    }

}

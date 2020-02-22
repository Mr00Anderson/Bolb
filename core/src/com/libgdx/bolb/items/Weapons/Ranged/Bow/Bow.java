package com.libgdx.bolb.items.Weapons.Ranged.Bow;


import com.libgdx.bolb.items.Weapons.Ranged.Ranged;

import java.sql.Savepoint;

public class Bow extends Ranged {

    public int chargetime;

    public Bow(String name, int damage, int range, int chargetime, int maxammo, float reloadspeed) {
        super(name, damage, range, maxammo, reloadspeed);
        this.chargetime = chargetime;
    }

    public int GetChargeTime(){return chargetime;}

}

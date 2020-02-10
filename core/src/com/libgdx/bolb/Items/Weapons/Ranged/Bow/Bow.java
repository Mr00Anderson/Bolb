package com.libgdx.bolb.Items.Weapons.Ranged.Bow;


import com.libgdx.bolb.Items.Weapons.Ranged.Ranged;

public class Bow extends Ranged {

    public int chargetime;

    public Bow(String name, int damage, int range, int chargetime, int maxammo, float reloadspeed) {
        super(name, damage, range, maxammo, reloadspeed);
        this.chargetime = chargetime;
    }

    public int GetChargeTime(){return chargetime;}

}

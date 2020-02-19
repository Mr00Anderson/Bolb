package com.libgdx.bolb.items.Weapons.Ranged;

public class Ranged {
    public int range;
    public int maxammo;

    public Ranged(String name, int damage, int range, int maxammo, float reloadspeed) {
        //super(name, damage, reloadspeed);
        this.range = range;
        this.maxammo = maxammo;
    }

    public int GetRange(){return range;}
    public int GetMaxAmmo(){return maxammo;}

}

package com.libgdx.bolb.Items.Weapons;

public class Weapon {

    public String name;
    public int damage;
    public float reloadspeed;

    public Weapon(String name, int damage, float reloadspeed){

    this.name = name;
    this.damage = damage;
    this.reloadspeed = reloadspeed;

    }

    public String GetName(){
        return name;
    }
    public int GetDamage(){return damage;}
    public float getReloadspeed() {
        return reloadspeed;
    }
}

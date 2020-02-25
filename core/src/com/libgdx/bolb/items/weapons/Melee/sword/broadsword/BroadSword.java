package com.libgdx.bolb.items.weapons.Melee.sword.broadsword;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.World;
import com.libgdx.bolb.items.ItemType;
import com.libgdx.bolb.items.Rarity;
import com.libgdx.bolb.items.weapons.Melee.MeleeWeapon;

public class BroadSword extends MeleeWeapon {

    public float swing;
    public float swingspeed;

    public BroadSword(String name, String description, Rarity rarity, int damage, float reloadspeed, float swing, float swingspeed, Vector2 position, World world) {
        super(name, damage, description, rarity, reloadspeed, position, world);
        this.swing = swing;
        this.swingspeed = swingspeed;
    }

    public float getSwing() {
        return swing;
    }
    public float getSwingspeed() {
        return swingspeed;
    }

	@Override
	public ItemType getType() {
		return ItemType.BROADSWORD;
	}

	@Override
	public Rarity getRarity() {
		return Rarity.COMMON;
	}


}

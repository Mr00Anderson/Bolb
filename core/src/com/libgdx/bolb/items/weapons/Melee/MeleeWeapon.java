package com.libgdx.bolb.items.weapons.Melee;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.badlogic.gdx.physics.box2d.World;
import com.libgdx.bolb.Constants;
import com.libgdx.bolb.items.Rarity;
import com.libgdx.bolb.items.weapons.Weapon;

import java.util.ArrayList;
import java.util.List;

public abstract class MeleeWeapon extends Weapon {
    private float rangeBoxRadius;
    private Body b2dBody;
    private Vector2 position;
    private World world;
    private List<Body> collidingBodies; //stores list of all bodies currently colliding with the melee range box
    //TODO store reference to the player?

    public MeleeWeapon(String name, int damage, String description, Rarity rarity, float rangeBoxRadius, Vector2 position, World world) {
        super(name, damage, description, rarity);
        this.rangeBoxRadius = rangeBoxRadius;
        this.position = position;
        this.world = world;
        b2dBody = constructRangeBoxBody();
        collidingBodies = new ArrayList<>();
    }

    public float getRangeBoxRadius() {
        return rangeBoxRadius;
    }

    /**
     * Creates a Box2d Body with a sensor to detect collisions with other bodies. If the player melee attacks
     * while this sensor is active, all colliding objects will be damaged.
     */

    private Body constructRangeBoxBody() {
        PolygonShape boxShape = new PolygonShape();
        boxShape.setAsBox(rangeBoxRadius/2, rangeBoxRadius/2);

        FixtureDef boxFixture = new FixtureDef();
        boxFixture.shape = boxShape;
        boxFixture.isSensor = true;
        boxFixture.filter.categoryBits = Constants.MELEE_BITS;
        boxFixture.filter.maskBits = Constants.ATTACKABLE_BITS;

        BodyDef bDef = new BodyDef();
        bDef.position.set(position);

        Body boxBody = world.createBody(bDef);
        boxBody.createFixture(boxFixture);

        return boxBody;
    }
}

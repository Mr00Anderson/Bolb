package com.libgdx.bolb;


public abstract class Constants {
    /** Box2D filter data */
    public static final short MELEE_BITS = 1 << 1; //melee weapons
    public static final short ATTACKABLE_BITS = 1 << 2; //attackable objects/entities

    public static int PlayerX = 200;
    public static int PlayerY = 50;
    public static int PlayerWidth = 455;
    public static int PlayerHeight = 384;
    public static final float PlayerCycleTime = 0.46f;
    public static final int PlayerFrames = 3;

}

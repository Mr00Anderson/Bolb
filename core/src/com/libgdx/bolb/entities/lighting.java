package com.libgdx.bolb.entities;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.libgdx.bolb.Constants;
import com.libgdx.bolb.utilities.Animation;


public class lighting extends Actor {


    private final TextureRegion lighting;
    private final Animation lightinganimation;
    private final Texture LIGHTING;
    private int hue;
    private float saturation, brightness;



    public lighting(int hue, float saturation, float brightness) {

        this.hue = hue;
        this.saturation = saturation;
        this.brightness = brightness;

        this.LIGHTING = new Texture("Entities/Lighting-Animation.png");

        this.lighting = new TextureRegion(LIGHTING);


        this.lightinganimation = new Animation(lighting,Constants.PlayerFrames,Constants.PlayerCycleTime);


        lighting.this.setSize(Constants.PlayerWidth,Constants.PlayerHeight);
        lighting.this.setPosition(Constants.PlayerX,Constants.PlayerY);

    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        Color color = getColor();
        batch.setColor(color);

        lightinganimation.update(Gdx.graphics.getDeltaTime());
        color.fromHsv(hue,saturation,brightness);
        lighting.this.setColor(color);
        batch.draw(lightinganimation.getFrame(),
                getX(), getY(),
                getOriginX(), getOriginY(),
                getWidth(), getHeight(),
                getScaleX(), getScaleY(),
                getRotation()
        );


    }
}

package com.libgdx.bolb.entities;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.libgdx.bolb.Constants;
import com.libgdx.bolb.utilities.Animation;

public class eyes extends Actor {


    private final TextureRegion eyes;
    private final Animation eyesanimation;
    private final Texture EYES;
    private int hue;
    private float saturation, brightness;




    public eyes(int hue, float saturation, float brightness) {

        this.hue = hue;
        this.saturation = saturation;
        this.brightness = brightness;

        this.EYES = new Texture("Entities/Eyes-Animation.png");

        this.eyes = new TextureRegion(EYES);


        this.eyesanimation = new Animation(eyes,Constants.PlayerFrames,Constants.PlayerCycleTime);


        eyes.this.setSize(Constants.PlayerWidth,Constants.PlayerHeight);
        eyes.this.setPosition(Constants.PlayerX,Constants.PlayerY);
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        Color color = getColor();
        batch.setColor(color);

        eyesanimation.update(Gdx.graphics.getDeltaTime());
        color.fromHsv(hue,saturation,brightness);
        eyes.this.setColor(color);
        batch.draw(eyesanimation.getFrame(),
                getX(), getY(),
                getOriginX(), getOriginY(),
                getWidth(), getHeight(),
                getScaleX(), getScaleY(),
                getRotation()
        );


    }
}

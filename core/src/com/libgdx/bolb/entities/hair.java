package com.libgdx.bolb.entities;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.libgdx.bolb.Constants;
import com.libgdx.bolb.utilities.Animation;

public class hair extends Actor {


    private final TextureRegion hair;
    private final Animation hairanimation;
    private final Texture HAIR;
    public static int hue;
    public static float saturation, brightness;




    public hair() {

        this.HAIR = new Texture("Entities/Hair-Animation.png");

        this.hair = new TextureRegion(HAIR);

        this.hairanimation = new Animation(hair,Constants.PlayerFrames,Constants.PlayerCycleTime);


        hair.this.setSize(Constants.PlayerWidth,Constants.PlayerHeight);
        hair.this.setPosition(Constants.PlayerX,Constants.PlayerY);
    }

    public  void setHSV(int hue,float saturation, float brightness) {
        hair.this.brightness = brightness;
        hair.this.saturation = saturation;
        hair.this.hue = hue;
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        Color color = getColor();
        batch.setColor(color);

        hairanimation.update(Gdx.graphics.getDeltaTime());
        color.fromHsv(hue,saturation,brightness);
        hair.this.setColor(color);
        batch.draw(hairanimation.getFrame(),
                getX(), getY(),
                getOriginX(), getOriginY(),
                getWidth(), getHeight(),
                getScaleX(), getScaleY(),
                getRotation()
        );


    }
}

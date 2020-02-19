package com.libgdx.bolb.entities;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.libgdx.bolb.Constants;
import com.libgdx.bolb.utilities.Animation;
import com.libgdx.bolb.utilities.scene2d.CustomActor;
import com.libgdx.bolb.utilities.scene2d.CustomAnimation;

public class character extends Actor {


    private final TextureRegion body;
    private final Animation bodyanimation;
    private final Texture BODY;
    private int hue;
    private float saturation, brightness;




    public character(int hue, float saturation, float brightness) {

        this.hue = hue;
        this.saturation = saturation;
        this.brightness = brightness;

        this.BODY = new Texture("Entities/Character-Animation.png");

        this.body = new TextureRegion(BODY);

        this.bodyanimation = new Animation(body,Constants.PlayerFrames,Constants.PlayerCycleTime);


        character.this.setSize(Constants.PlayerWidth,Constants.PlayerHeight);
        character.this.setPosition(Constants.PlayerX,Constants.PlayerY);

    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        Color color = getColor();
        batch.setColor(color);

        bodyanimation.update(Gdx.graphics.getDeltaTime());
        color.fromHsv(hue,saturation,brightness);
        character.this.setColor(color);
        batch.draw(bodyanimation.getFrame(),
                getX(), getY(),
                getOriginX(), getOriginY(),
                getWidth(), getHeight(),
                getScaleX(), getScaleY(),
                getRotation()
        );


    }
}




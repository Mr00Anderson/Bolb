package com.libgdx.bolb.entities;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.libgdx.bolb.Constants;
import com.libgdx.bolb.utilities.Animation;

public class body extends Actor {


    private final TextureRegion body;
    private final Animation bodyanimation;
    private final Texture BODY;
    public static int hue;
    public static float saturation, brightness;




    public body() {

        this.BODY = new Texture("Entities/Character-Animation.png");

        this.body = new TextureRegion(BODY);

        this.bodyanimation = new Animation(body,Constants.PlayerFrames,Constants.PlayerCycleTime);


        com.libgdx.bolb.entities.body.this.setSize(Constants.PlayerWidth,Constants.PlayerHeight);
        com.libgdx.bolb.entities.body.this.setPosition(Constants.PlayerX,Constants.PlayerY);

    }

    public  void setHSV(int hue,float saturation, float brightness) {
        body.this.brightness = brightness;
        body.this.saturation = saturation;
        body.this.hue = hue;
    }



    @Override
    public void draw(Batch batch, float parentAlpha) {
        Color color = getColor();
        batch.setColor(color);

        bodyanimation.update(Gdx.graphics.getDeltaTime());
        color.fromHsv(hue,saturation,brightness);
        com.libgdx.bolb.entities.body.this.setColor(color);
        batch.draw(bodyanimation.getFrame(),
                getX(), getY(),
                getOriginX(), getOriginY(),
                getWidth(), getHeight(),
                getScaleX(), getScaleY(),
                getRotation()
        );


    }
}




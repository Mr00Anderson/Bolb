package com.libgdx.bolb.utilities.scene2d;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.utils.Logger;

public class CustomActor extends Actor {

    private static final Logger log = new Logger(CustomActor.class.getName(), Logger.DEBUG);

    private final TextureRegion region;

    public CustomActor(TextureRegion region, int width, int height, int x, int y) {
        this.region = region;
        CustomActor.this.setSize(width,height);
        CustomActor.this.setPosition(x,y);
    }

    public CustomActor(TextureRegion region, int width, int height, int x, int y, boolean CenteredOrigin) {
        this.region = region;
        CustomActor.this.setSize(width,height);
        CustomActor.this.setPosition(x,y);
        if(CenteredOrigin = true){
            CustomActor.this.setOrigin(CustomActor.this.getWidth()/2, CustomActor.this.getHeight()/2);
        }
    }

    public CustomActor(TextureRegion region, int width, int height, int x, int y, boolean CenteredOrigin, float originX, float originY) {
        this.region = region;
        CustomActor.this.setSize(width,height);
        CustomActor.this.setPosition(x,y);
        CustomActor.this.setOrigin(originX,originY);
    }



    @Override
    public void draw(Batch batch, float parentAlpha) {
        Color color = getColor();
        batch.setColor(color);

        batch.draw(region,
                getX(), getY(),
                getOriginX(), getOriginY(),
                getWidth(), getHeight(),
                getScaleX(), getScaleY(),
                getRotation()
        );

    }
}
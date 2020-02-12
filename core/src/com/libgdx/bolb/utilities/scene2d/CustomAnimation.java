package com.libgdx.bolb.utilities.scene2d;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.Logger;
import com.libgdx.bolb.utilities.Animation;

//Animation for scene2d stages
public class CustomAnimation extends Actor {

    private static final Logger log = new Logger(CustomAnimation.class.getName(), Logger.DEBUG);

    private final TextureRegion region;
    private final int frameCount;
    private final float cycleTime;
    private final Animation animation;

    public CustomAnimation(TextureRegion region, int frameCount, float cycleTime, int width, int height, int x, int y) {
        this.region = region;
        this.frameCount = frameCount;
        this.cycleTime = cycleTime;
        this.animation = new Animation(region,frameCount,cycleTime);
        CustomAnimation.this.setSize(width,height);
        CustomAnimation.this.setPosition(x,y);
    }

    public CustomAnimation(TextureRegion region, int frameCount, float cycleTime, int width, int height, int x, int y, boolean CenteredOrigin) {
        this.region = region;
        this.frameCount = frameCount;
        this.cycleTime = cycleTime;
        this.animation = new Animation(region,frameCount,cycleTime);
        CustomAnimation.this.setSize(width,height);
        CustomAnimation.this.setPosition(x,y);
        if(CenteredOrigin = true){
            CustomAnimation.this.setOrigin(CustomAnimation.this.getWidth()/2, CustomAnimation.this.getHeight()/2);
        }
    }

    public CustomAnimation(TextureRegion region, int frameCount, float cycleTime, int width, int height, int x, int y, float originX, float originY) {
        this.region = region;
        this.frameCount = frameCount;
        this.cycleTime = cycleTime;
        this.animation = new Animation(region,frameCount,cycleTime);
        CustomAnimation.this.setSize(width,height);
        CustomAnimation.this.setPosition(x,y);
        CustomAnimation.this.setOrigin(originX,originY);
    }


    @Override
    public void draw(Batch batch, float parentAlpha) {
        Color color = getColor();
        batch.setColor(color);

        animation.update(Gdx.graphics.getDeltaTime());
        batch.draw(animation.getFrame(),
                getX(), getY(),
                getOriginX(), getOriginY(),
                getWidth(), getHeight(),
                getScaleX(), getScaleY(),
                getRotation()
        );

    }
}

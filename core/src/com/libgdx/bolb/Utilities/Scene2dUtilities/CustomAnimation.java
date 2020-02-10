package com.libgdx.bolb.Utilities.Scene2dUtilities;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.utils.Logger;
import com.libgdx.bolb.Utilities.Animation;

//Animation for scene2d stages
public class CustomAnimation extends Actor {

    private static final Logger log = new Logger(CustomAnimation.class.getName(), Logger.DEBUG);

    private final TextureRegion region;
    private final int frameCount;
    private final float cycleTime;
    private final Animation animation;

    public CustomAnimation(TextureRegion region, int frameCount, float cycleTime) {
        this.region = region;
        this.frameCount = frameCount;
        this.cycleTime = cycleTime;
        this.animation = new Animation(region,frameCount,cycleTime);
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

package com.libgdx.bolb.utilities.scene2d;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Preferences;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.utils.Logger;

public class CustomActor extends Actor {

    private static final Logger log = new Logger(CustomActor.class.getName(), Logger.DEBUG);

    private final TextureRegion region;
    public int x, y, width, height;
    public float OriginX, OriginY;
    public boolean CenteredOrigin;


    public static class Builder {
        private final TextureRegion region;

        private int x = 0;
        private int y = 0;
        private int OriginX = 0;
        private int OriginY = 0;
        private int width = 455;
        private int height = 384;
        private boolean CenteredOrigin = true;

        public Builder(TextureRegion region){
            this.region = region;
        }
        public Builder xPosition(int val){
            x = val; return this;
        }
        public Builder yPosition(int val){
            y = val; return this;
        }
        public Builder xOriginPosition(int val){
            OriginX = val; return this;
        }
        public Builder yOriginPosition(int val){
            OriginY = val; return this;
        }
        public Builder width(int val){
            width = val; return this;
        }
        public Builder height(int val){
            height = val; return this;
        }
        public Builder centeredOrigin(boolean tf){
            CenteredOrigin = tf; return this;
        }
    }

    public CustomActor(Builder builder){
        this.region = builder.region;
        this.x = builder.x;
        this.y = builder.y;
        CustomActor.this.setSize(builder.width,builder.height);
        CustomActor.this.setPosition(builder.x, builder.y);
        CustomActor.this.setOrigin(builder.OriginX,builder.OriginY);
        if (builder.CenteredOrigin) {
            CustomActor.this.setOrigin(CustomActor.this.getWidth() / 2, CustomActor.this.getHeight() / 2);
        }

    }

    public CustomActor(TextureRegion region, int width, int height, int x, int y) {
        this.region = region;
        this.x = x;
        this.y = y;
        CustomActor.this.setSize(width, height);
        CustomActor.this.setPosition(x, y);
    }

    public CustomActor(TextureRegion region, int width, int height, int x, int y, boolean CenteredOrigin) {
        this.region = region;
        this.x = x;
        this.y = y;
        CustomActor.this.setSize(width, height);
        CustomActor.this.setPosition(x, y);
        if (CenteredOrigin = true) {
            CustomActor.this.setOrigin(CustomActor.this.getWidth() / 2, CustomActor.this.getHeight() / 2);
        }

//        x = preferences.getInteger("X");
//        y = preferences.getInteger("Y");
    }

    public CustomActor(TextureRegion region, int width, int height, int x, int y, float originX, float originY) {
        this.region = region;
        this.x = x;
        this.y = y;
        CustomActor.this.setSize(width, height);
        CustomActor.this.setPosition(x, y);
        CustomActor.this.setOrigin(originX, originY);

//        x = preferences.getInteger("X");
//        y = preferences.getInteger("Y");
    }


    @Override
    public void draw(Batch batch, float parentAlpha) {
        Color color = getColor();
        batch.setColor(color);
//        preferences.putFloat("X", CustomActor.this.getX());
//        preferences.putFloat("Y", CustomActor.this.getY());
        batch.draw(region,
                getX(), getY(),
                getOriginX(), getOriginY(),
                getWidth(), getHeight(),
                getScaleX(), getScaleY(),
                getRotation()
        );
//        preferences.flush();
    }
}
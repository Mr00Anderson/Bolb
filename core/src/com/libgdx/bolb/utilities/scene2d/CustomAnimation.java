package com.libgdx.bolb.utilities.scene2d;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.utils.Logger;
import com.libgdx.bolb.utilities.Animation;

//Animation for scene2d stages
public class CustomAnimation extends Actor {

    private static final Logger log = new Logger(CustomAnimation.class.getName(), Logger.DEBUG);


    private final Animation animation;

    private int hue;
    private float saturation, brightness;
    private TextureRegion region;
    public int x, y, width, height;
    public float OriginX, OriginY;
    public boolean CenteredOrigin;

    public static class Builder {
        private final TextureRegion region;
        private final Animation animation;
        private int x = 0;
        private int y = 0;
        private float cycleTime = 0.4f;
        private int frameCount = 3;
        private int OriginX = 0;
        private int OriginY = 0;
        private int width = 455;
        private int height = 384;
        private boolean CenteredOrigin = true;

        public Builder(TextureRegion region){
            this.region = region;
            animation = new Animation(region, frameCount, cycleTime);
        }
        public CustomAnimation.Builder xPosition(int val){
            x = val; return this;
        }
        public CustomAnimation.Builder yPosition(int val){
            y = val; return this;
        }
        public CustomAnimation.Builder xOriginPosition(int val){
            OriginX = val; return this;
        }
        public CustomAnimation.Builder yOriginPosition(int val){
            OriginY = val; return this;
        }
        public CustomAnimation.Builder width(int val){
            width = val; return this;
        }
        public CustomAnimation.Builder height(int val){
            height = val; return this;
        }
        public CustomAnimation.Builder centeredOrigin(boolean tf){
            CenteredOrigin = tf; return this;
        }
        public CustomAnimation.Builder frameCount(int val){
            frameCount = val; return this;
        }
        public CustomAnimation.Builder cycleTime(float val){
            cycleTime = val; return this;
        }
        public CustomAnimation build(){
            return new CustomAnimation(this);
        }
    }

    public CustomAnimation(Builder builder){
        this.animation = builder.animation;
        CustomAnimation.this.setSize(builder.width,builder.height);
        CustomAnimation.this.setPosition(builder.x,builder.y);
        if(builder.CenteredOrigin = true){
            CustomAnimation.this.setOrigin(CustomAnimation.this.getWidth()/2, CustomAnimation.this.getHeight()/2);
        }
        CustomAnimation.this.setOrigin(builder.OriginX,builder.OriginY);
    }
    public CustomAnimation(TextureRegion region, int frameCount, float cycleTime, int width, int height, int x, int y) {
        this.animation = new Animation(region,frameCount,cycleTime);
        CustomAnimation.this.setSize(width,height);
        CustomAnimation.this.setPosition(x,y);
    }


    public  void setHSV(int hue,float saturation, float brightness) {
        this.brightness = brightness;
        this.saturation = saturation;
        this.hue = hue;
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        Color color = getColor();
        batch.setColor(color);

        animation.update(Gdx.graphics.getDeltaTime());
        color.fromHsv(hue,saturation,brightness);
        this.setColor(color);
        batch.draw(animation.getFrame(),
                getX(), getY(),
                getOriginX(), getOriginY(),
                getWidth(), getHeight(),
                getScaleX(), getScaleY(),
                getRotation()
        );

    }
}

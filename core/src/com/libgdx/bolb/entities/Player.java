package com.libgdx.bolb.entities;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.libgdx.bolb.Constants;
import com.libgdx.bolb.utilities.Animation;

import static com.badlogic.gdx.scenes.scene2d.actions.Actions.rotateBy;

public class player {

    private body body;
    private lighting lighting;
    private eyes eyes;
    private hair hair;
    public int X;
    public int Y;
    private static int CurrentThing;

    public player() {
        body = new body();
        eyes = new eyes();
        lighting = new lighting();
        hair = new hair();

    }

    public void update(float dt) {
    }

    public void drawbody(Stage stage) {
        stage.addActor(body);
        stage.addActor(lighting);
        stage.addActor(eyes);
        stage.addActor(hair);
    }

    public void setHSV(int hue, float saturation, float brightness) {
        if (CurrentThing == 0) {
            this.body.setHSV(hue, saturation, brightness);
            this.lighting.setHSV(hue - 15, saturation, brightness);
        } else if (CurrentThing == 1) {
            this.hair.setHSV(hue, saturation, brightness);
        } else if (CurrentThing == 2) {
            this.eyes.setHSV(hue, saturation, brightness);
        }

    }

    public class lighting extends Actor {


        private final TextureRegion lighting;
        private final Animation lightinganimation;
        private final Texture LIGHTING;
        private int hue;
        private float saturation, brightness;


        public lighting() {

            this.LIGHTING = new Texture("Entities/Lighting-Animation.png");

            this.lighting = new TextureRegion(LIGHTING);


            this.lightinganimation = new Animation(lighting, Constants.PlayerFrames,Constants.PlayerCycleTime);


            lighting.this.setSize(Constants.PlayerWidth,Constants.PlayerHeight);
            lighting.this.setPosition(player.this.X,player.this.Y);

        }


        public  void setHSV(int hue,float saturation, float brightness) {
            lighting.this.brightness = brightness;
            lighting.this.saturation = saturation;
            lighting.this.hue = hue;
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

    public class body extends Actor {


        private final TextureRegion body;
        private final Animation bodyanimation;
        private final Texture BODY;
        private int hue;
        private float saturation, brightness;




        public body() {

            this.BODY = new Texture("Entities/Character-Animation.png");

            this.body = new TextureRegion(BODY);

            this.bodyanimation = new Animation(body,Constants.PlayerFrames,Constants.PlayerCycleTime);


            body.this.setSize(Constants.PlayerWidth,Constants.PlayerHeight);
            body.this.setPosition(player.this.X,player.this.Y);

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
            body.this.setColor(color);
            batch.draw(bodyanimation.getFrame(),
                    getX(), getY(),
                    getOriginX(), getOriginY(),
                    getWidth(), getHeight(),
                    getScaleX(), getScaleY(),
                    getRotation()
            );


        }
    }


    public class eyes extends Actor {


        private final TextureRegion eyes;
        private final Animation eyesanimation;
        private final Texture EYES;
        private int hue;
        private float saturation, brightness;




        public eyes() {


            this.EYES = new Texture("Entities/Eyes-Animation.png");

            this.eyes = new TextureRegion(EYES);


            this.eyesanimation = new Animation(eyes,Constants.PlayerFrames,Constants.PlayerCycleTime);


            eyes.this.setSize(Constants.PlayerWidth,Constants.PlayerHeight);
            eyes.this.setPosition(player.this.X,player.this.Y);
        }

        public  void setHSV(int hue,float saturation, float brightness) {
            eyes.this.brightness = brightness;
            eyes.this.saturation = saturation;
            eyes.this.hue = hue;
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


    public class hair extends Actor {


        private final TextureRegion hair;
        private final Animation hairanimation;
        private final Texture HAIR;
        private int hue;
        private float saturation, brightness;




        public hair() {

            this.HAIR = new Texture("Entities/Hair-Animation.png");

            this.hair = new TextureRegion(HAIR);

            this.hairanimation = new Animation(hair,Constants.PlayerFrames,Constants.PlayerCycleTime);


            hair.this.setSize(Constants.PlayerWidth,Constants.PlayerHeight);
            hair.this.setPosition(player.this.X,player.this.Y);
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


}

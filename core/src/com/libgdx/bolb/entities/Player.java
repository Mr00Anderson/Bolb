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
import com.libgdx.bolb.utilities.scene2d.CustomAnimation;

import static com.badlogic.gdx.scenes.scene2d.actions.Actions.rotateBy;

public class Player {

	private final TextureRegion bodyRegion;
    private final Texture BODY;
    private CustomAnimation body;
    
    private TextureRegion lightingRegion;
    private Texture LIGHTING;
    private CustomAnimation lighting;
    
    private final TextureRegion eyesRegion;
    private final Texture EYES;
    private CustomAnimation eyes;
    
    private final TextureRegion hairRegion;
    private final Texture HAIR;
    private CustomAnimation hair;
    
    public int X;
    public int Y;
    private static int CurrentThing;

    public Player() {
    	this.LIGHTING = new Texture("Entities/Lighting-Animation.png");
    	this.lightingRegion = new TextureRegion(LIGHTING);

    	this.BODY = new Texture("Entities/Character-Animation.png");
        this.bodyRegion = new TextureRegion(BODY);

        this.EYES = new Texture("Entities/Eyes-Animation.png");
        this.eyesRegion = new TextureRegion(EYES);

        this.HAIR = new Texture("Entities/Hair-Animation.png");
        this.hairRegion = new TextureRegion(HAIR);

        body = new CustomAnimation(bodyRegion, Constants.PlayerFrames,Constants.PlayerCycleTime, Constants.PlayerWidth,Constants.PlayerHeight, Player.this.X, Player.this.Y);
        eyes = new CustomAnimation(eyesRegion, Constants.PlayerFrames,Constants.PlayerCycleTime, Constants.PlayerWidth,Constants.PlayerHeight, Player.this.X, Player.this.Y);
        lighting = new CustomAnimation(lightingRegion, Constants.PlayerFrames,Constants.PlayerCycleTime, Constants.PlayerWidth,Constants.PlayerHeight, Player.this.X, Player.this.Y);
        hair = new CustomAnimation(hairRegion, Constants.PlayerFrames,Constants.PlayerCycleTime, Constants.PlayerWidth,Constants.PlayerHeight, Player.this.X, Player.this.Y);

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

}

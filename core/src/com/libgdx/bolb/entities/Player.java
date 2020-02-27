package com.libgdx.bolb.entities;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.libgdx.bolb.Constants;
import com.libgdx.bolb.utilities.scene2d.CustomAnimation;

public class Player {

    public static final Player player = new Player();

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

    public static int X;
    public static int Y;
    private static int CurrentThing;

    private Player() {
        this.LIGHTING = new Texture("Entities/Lighting-Animation.png");
        this.lightingRegion = new TextureRegion(LIGHTING);

        this.BODY = new Texture("Entities/Character-Animation.png");
        this.bodyRegion = new TextureRegion(BODY);

        this.EYES = new Texture("Entities/Eyes-Animation.png");
        this.eyesRegion = new TextureRegion(EYES);

        this.HAIR = new Texture("Entities/Hair-Animation.png");
        this.hairRegion = new TextureRegion(HAIR);

        body = new CustomAnimation(bodyRegion, Constants.PlayerFrames, Constants.PlayerCycleTime, Constants.PlayerWidth, Constants.PlayerHeight, Player.this.X, Player.this.Y);
        eyes = new CustomAnimation(eyesRegion, Constants.PlayerFrames, Constants.PlayerCycleTime, Constants.PlayerWidth, Constants.PlayerHeight, Player.this.X, Player.this.Y);
        lighting = new CustomAnimation(lightingRegion, Constants.PlayerFrames, Constants.PlayerCycleTime, Constants.PlayerWidth, Constants.PlayerHeight, Player.this.X, Player.this.Y);
        hair = new CustomAnimation(hairRegion, Constants.PlayerFrames, Constants.PlayerCycleTime, Constants.PlayerWidth, Constants.PlayerHeight, Player.this.X, Player.this.Y);

    }

    public static Player getPlayer(){ return player;}


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

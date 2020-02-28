package com.libgdx.bolb.entities;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.libgdx.bolb.utilities.scene2d.CustomAnimation;

public class Player {

    public static final Player player = new Player();

    private final TextureRegion bodyRegion, lightingRegion, eyesRegion, hairRegion;
    private final Texture BODY, LIGHTING, HAIR, EYES;
    private CustomAnimation body, hair,eyes, lighting;
    private int X,Y, CurrentThing;
    public boolean isFlipped;

    private Player() {

        this.LIGHTING = new Texture("Entities/Lighting-Animation.png");
        this.lightingRegion = new TextureRegion(LIGHTING);

        this.BODY = new Texture("Entities/Character-Animation.png");
        this.bodyRegion = new TextureRegion(BODY);

        this.EYES = new Texture("Entities/Eyes-Animation.png");
        this.eyesRegion = new TextureRegion(EYES);

        this.HAIR = new Texture("Entities/Hair-Animation.png");
        this.hairRegion = new TextureRegion(HAIR);

        body = new CustomAnimation.Builder(bodyRegion).build();
        eyes = new CustomAnimation.Builder(eyesRegion).build();
        lighting = new CustomAnimation.Builder(lightingRegion).build();
        hair = new CustomAnimation.Builder(hairRegion).build();

    }

    public static Player getPlayer(){ return player;}

    public void update(float dt) {

        body.setPosition(Player.this.X,Player.this.Y);
        eyes.setPosition(Player.this.X,Player.this.Y);
        hair.setPosition(Player.this.X,Player.this.Y);
        lighting.setPosition(Player.this.X,Player.this.Y);
        if(Gdx.input.isKeyPressed(Input.Keys.W)){Player.getPlayer().up();}
        if(Gdx.input.isKeyPressed(Input.Keys.S)){Player.getPlayer().down();}
        if(Gdx.input.isKeyPressed(Input.Keys.A)){Player.getPlayer().left();}
        if(Gdx.input.isKeyPressed(Input.Keys.D)){Player.getPlayer().right();}
    }

    private void up(){ Y += 6;}
    private void down(){ Y -= 6;}
    private void right(){ X += 6;}
    private void left(){ X -= 6;}

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

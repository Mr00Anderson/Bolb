package com.libgdx.bolb.entities;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.g2d.ParticleEffect;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.libgdx.bolb.management.BolbManager;
import com.libgdx.bolb.utilities.scene2d.CustomAnimation;
import com.libgdx.bolb.utilities.scene2d.ParticleActor;

import java.util.Random;

public class Player {

    public static final Player player = new Player();

    private CustomAnimation body, hair, eyes, lighting, hairshine;
    private ParticleEffect runEffect;
    private ParticleActor runActor;
    private int X, Y, CurrentThing;
    BolbManager bolbManager;

    private Player() {

        bolbManager = new BolbManager();
        bolbManager.loadPlayer();

        X = 180;
        Y = -0;


        runEffect = new ParticleEffect();
        runEffect.load(Gdx.files.internal("Environment/Sparticle"), Gdx.files.internal("Environment"));

        body = new CustomAnimation(new TextureRegion(bolbManager.get(bolbManager.Body)), 3, 0.4f, 455, 382, Player.this.X, Player.this.Y);
        eyes = new CustomAnimation(new TextureRegion(bolbManager.get(bolbManager.Eyes)), 3, 0.4f, 455, 382, Player.this.X, Player.this.Y);
        lighting = new CustomAnimation(new TextureRegion(bolbManager.get(bolbManager.Lighting)), 3, 0.4f, 455, 382, Player.this.X, Player.this.Y);
        hair = new CustomAnimation(new TextureRegion(bolbManager.get(bolbManager.JesterHair)), 3, 0.4f, 455, 382, Player.this.X, Player.this.Y);
        hairshine = new CustomAnimation(new TextureRegion(bolbManager.get(bolbManager.JesterHairShine)), 3, 0.4f, 455, 382, Player.this.X, Player.this.Y);
        runActor = new ParticleActor(runEffect, Player.this.X + 186, Player.this.Y + 120);


        runActor.getEffect().findEmitter("Sparticle").scaleSize(0.25f);
        runActor.getEffect().findEmitter("Sparticle").getTint().setColors(new float[]{1f, 0.67f, 0f, 1f});

    }

    public static Player getPlayer() {
        return player;
    }

    public void update(float dt) {


        body.setPosition(Player.this.X, Player.this.Y);
        eyes.setPosition(Player.this.X, Player.this.Y);
        hair.setPosition(Player.this.X, Player.this.Y);
        lighting.setPosition(Player.this.X, Player.this.Y);
        hairshine.setPosition(Player.this.X, Player.this.Y);


        if (Right() && Gdx.input.isKeyPressed(Input.Keys.D)) {
            Player.getPlayer().flip();
        }
        if (Left() && Gdx.input.isKeyPressed(Input.Keys.A)) {
            Player.getPlayer().flip();
        }

        setParticlePosition();


        if (Gdx.input.isKeyPressed(Input.Keys.W)) {
            Player.getPlayer().up();
        }

        if (Gdx.input.isKeyPressed(Input.Keys.S)) {
            Player.getPlayer().down();
        }

        if (Gdx.input.isKeyPressed(Input.Keys.A)) {
            Player.getPlayer().left();
        }

        if (Gdx.input.isKeyPressed(Input.Keys.D)) {
            Player.getPlayer().right();
        }

        if (!(Gdx.input.isKeyPressed(Input.Keys.W) || Gdx.input.isKeyPressed(Input.Keys.A) || Gdx.input.isKeyPressed(Input.Keys.S) || Gdx.input.isKeyPressed(Input.Keys.D))) {
            runActor.pause("Sparticle");
        }

        if ((Gdx.input.isKeyPressed(Input.Keys.W) || Gdx.input.isKeyPressed(Input.Keys.A) || Gdx.input.isKeyPressed(Input.Keys.S) || Gdx.input.isKeyPressed(Input.Keys.D))) {
            runActor.resume("Sparticle");
        }

    }

    private void up() {
        Y += 6;
    }

    private void down() {
        Y -= 6;
    }

    private void right() {
        X += 6;
    }

    private void left() {
        X -= 6;
    }

    public void drawbody(Stage stage) {
        stage.addActor(body);
        stage.addActor(lighting);
        stage.addActor(eyes);
        stage.addActor(hair);
        stage.addActor(hairshine);
        stage.addActor(runActor);
    }


    private void setParticlePosition() {
        if (Left()) {
            runActor.setPosition(Player.this.X + 195, Player.this.Y + 120);
        } else if (Right()) {
            runActor.setPosition(Player.this.X + 255, Player.this.Y + 120);
        }
    }

    private void flip() {
        Player.getPlayer().body.getAnimation().getFrame().flip(true, false);
        Player.getPlayer().lighting.getAnimation().getFrame().flip(true, false);
        Player.getPlayer().hair.getAnimation().getFrame().flip(true, false);
        Player.getPlayer().eyes.getAnimation().getFrame().flip(true, false);
        Player.getPlayer().hairshine.getAnimation().getFrame().flip(true, false);
    }

    public void setCurrentThing(int val) {
        CurrentThing = val;
    }


    private boolean Left() {
        return !Player.getPlayer().body.getAnimation().getFrame().isFlipX();

    }

    private boolean Right() {
        return Player.getPlayer().body.getAnimation().getFrame().isFlipX();

    }

    public void setHSV(int hue, float saturation, float brightness) {
        if (CurrentThing == 1) {
            this.body.setHSV(hue, saturation, brightness);
            this.lighting.setHSV(hue - 15, saturation, brightness);
        } else if (CurrentThing == 2) {
            this.hair.setHSV(hue, saturation, brightness);
        } else if (CurrentThing == 3) {
            this.eyes.setHSV(hue, saturation, brightness);
        }
        this.hairshine.setHSV(0, 0, 1);

    }


    public int getPostionX() {
        return this.X + 200;
    }


    public int getPostionY() {
        return this.Y + 170;
    }


    public static float generateRandomFloat() {

        Random random = new Random();

        return random.nextFloat();

    }
}

package com.libgdx.bolb.entities;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.ParticleEffect;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.libgdx.bolb.inventory.Inventory;
import com.libgdx.bolb.utilities.scene2d.CustomAnimation;
import com.libgdx.bolb.utilities.scene2d.ParticleActor;

import java.util.Random;

public class Player {

	public static final Player player = new Player();

	private final TextureRegion bodyRegion, lightingRegion, eyesRegion, hairRegion, shineRegion, eyeshineRegion;
	private final Texture BODY, LIGHTING, HAIR, EYES, SHINE, EYE_SHINE;
	private CustomAnimation body, hair,eyes, lighting, shine, eyeshine;
	private ParticleEffect runEffect;
	private ParticleActor runActor;
	private int X,Y, CurrentThing;
	public boolean isFlipped;

	private Player() {

		X = 180;
		Y = -0;

		this.LIGHTING = new Texture("Entities/Lighting-Animation.png");
		this.lightingRegion = new TextureRegion(LIGHTING);

		this.SHINE = new Texture("Entities/Shine-Animation.png");
		this.shineRegion = new TextureRegion(SHINE);

		this.BODY = new Texture("Entities/Character-Animation.png");
		this.bodyRegion = new TextureRegion(BODY);

		this.EYES = new Texture("Entities/Eyes-Animation.png");
		this.eyesRegion = new TextureRegion(EYES);

		this.EYE_SHINE = new Texture("Entities/EyeShine-Animation.png");
		this.eyeshineRegion = new TextureRegion(EYE_SHINE);

		this.HAIR = new Texture("Entities/Hair-Animation.png");
		this.hairRegion = new TextureRegion(HAIR);

		runEffect = new ParticleEffect();
		runEffect.load(Gdx.files.internal("Environment/Sparticle"), Gdx.files.internal("Environment"));

		body = new CustomAnimation(bodyRegion,3,0.4f,455,382,Player.this.X,Player.this.Y);
		eyes = new CustomAnimation(eyesRegion,3,0.4f,455,382,Player.this.X,Player.this.Y);
		lighting = new CustomAnimation(lightingRegion,3,0.4f,455,382,Player.this.X,Player.this.Y);
		hair = new CustomAnimation(hairRegion,3,0.4f,455,382,Player.this.X,Player.this.Y);
		shine = new CustomAnimation(shineRegion,3,0.4f,455,382,Player.this.X,Player.this.Y);
		eyeshine = new CustomAnimation(eyeshineRegion,3,0.4f,455,382,Player.this.X,Player.this.Y);
		runActor = new ParticleActor(runEffect,Player.this.X + 186,Player.this.Y + 120);


		runActor.getEffect().findEmitter("Sparticle").scaleSize(0.25f);
		runActor.getEffect().findEmitter("Sparticle").getTint().setColors(new float[]{1f, 0.67f,0f, 1f});

	}

	public static Player getPlayer(){ return player;}

	public void update(float dt) {




		body.setPosition(Player.this.X,Player.this.Y);
		eyes.setPosition(Player.this.X,Player.this.Y);
		hair.setPosition(Player.this.X,Player.this.Y);
		lighting.setPosition(Player.this.X,Player.this.Y);
		shine.setPosition(Player.this.X,Player.this.Y);
		eyeshine.setPosition(Player.this.X,Player.this.Y);
		runActor.setPosition(Player.this.X + 186,Player.this.Y + 120);

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
		stage.addActor(shine);
		stage.addActor(runActor);
	}


	public void setCurrentThing(int val){
		CurrentThing = val;
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
		this.shine.setHSV(0, 0, 1);

	}


	public int getPostionX(){return this.X + 200;}


	public int getPostionY(){return this.Y + 170;}


	public static float generateRandomFloat(){

		Random random = new Random();

		return random.nextFloat();

	}
}

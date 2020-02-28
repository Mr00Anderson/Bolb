package com.libgdx.bolb.entities;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.libgdx.bolb.utilities.scene2d.CustomAnimation;

public class Player {

	public static final Player player = new Player();

	private final TextureRegion bodyRegion, lightingRegion, eyesRegion, hairRegion, shineRegion, eyeshineRegion;
	private final Texture BODY, LIGHTING, HAIR, EYES, SHINE, EYE_SHINE;
	private CustomAnimation body, hair,eyes, lighting, shine, eyeshine;
	private int X,Y, CurrentThing;
	public boolean isFlipped;

	private Player() {


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

		body = new CustomAnimation(bodyRegion,3,0.4f,455,382,Player.this.X,Player.this.Y);
		eyes = new CustomAnimation(eyesRegion,3,0.4f,455,382,Player.this.X,Player.this.Y);
		lighting = new CustomAnimation(lightingRegion,3,0.4f,455,382,Player.this.X,Player.this.Y);
		hair = new CustomAnimation(hairRegion,3,0.4f,455,382,Player.this.X,Player.this.Y);
		shine = new CustomAnimation(shineRegion,3,0.4f,455,382,Player.this.X,Player.this.Y);
		eyeshine = new CustomAnimation(eyeshineRegion,3,0.4f,455,382,Player.this.X,Player.this.Y);



	}

	public static Player getPlayer(){ return player;}

	public void update(float dt) {



		body.setPosition(Player.this.X,Player.this.Y);
		eyes.setPosition(Player.this.X,Player.this.Y);
		hair.setPosition(Player.this.X,Player.this.Y);
		lighting.setPosition(Player.this.X,Player.this.Y);
		shine.setPosition(Player.this.X,Player.this.Y);
		eyeshine.setPosition(Player.this.X,Player.this.Y);

		if(Gdx.input.isKeyPressed(Input.Keys.W)){Player.getPlayer().up();}
		if(Gdx.input.isKeyPressed(Input.Keys.S)){Player.getPlayer().down();}
		if(Gdx.input.isKeyPressed(Input.Keys.A)){Player.getPlayer().left();}
		if(Gdx.input.isKeyPressed(Input.Keys.D)){Player.getPlayer().right();}
		if(Gdx.input.isKeyPressed(Input.Keys.NUM_0)){CurrentThing = 0;}
		if(Gdx.input.isKeyPressed(Input.Keys.NUM_1)){CurrentThing = 1;}
		if(Gdx.input.isKeyPressed(Input.Keys.NUM_2)){CurrentThing = 2;}

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
		this.shine.setHSV(0, 0, 1);

	}

}

package com.libgdx.bolb.states;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.ExtendViewport;
import com.libgdx.bolb.entities.player;
import com.libgdx.bolb.management.states.GameStateManager;
import com.libgdx.bolb.management.states.State;
import com.libgdx.bolb.utilities.General;
import com.libgdx.bolb.utilities.UI.SliderButton;

import static com.libgdx.bolb.utilities.General.ClearScreen;

public class Customization extends State {

    private Stage stage;
    private player Player;
    private int hue;
    private float saturation, brightness;
    private SliderButton slide;


    public Customization(GameStateManager gsm) {
        super(gsm);

        Player = new player();
        slide = new SliderButton(50,350);
        stage = new Stage(new ExtendViewport(General.WIDTH, General.HEIGHT));
        Player.drawbody(stage);
        stage.addActor(slide);
        Gdx.input.setInputProcessor(stage);


    }

    @Override
    protected void handleInput() {

        //Hue
        if (Gdx.input.isKeyPressed(Input.Keys.H) && Gdx.input.isKeyPressed(Input.Keys.UP)) {
            hue += 1;
        }
        if (Gdx.input.isKeyPressed(Input.Keys.H) && Gdx.input.isKeyPressed(Input.Keys.DOWN)) {
            hue -= 1;
        }
        if (hue > 360) {
            hue = 0;
        } else if (hue < 0) {
            hue = 360;
        }

        //Saturation
        if (Gdx.input.isKeyPressed(Input.Keys.S) && Gdx.input.isKeyPressed(Input.Keys.UP)) {
            saturation += 0.0001;
        }
        if (Gdx.input.isKeyPressed(Input.Keys.S) && Gdx.input.isKeyPressed(Input.Keys.DOWN)) {
            saturation -= 0.0001;
        }
        if (saturation > 0) {
            saturation = 1;
        } else if (saturation < 1) {
            saturation = 0;
        }

        //Brightness
        if (Gdx.input.isKeyPressed(Input.Keys.B) && Gdx.input.isKeyPressed(Input.Keys.UP)) {
            brightness += 0.01;
        }
        if (Gdx.input.isKeyPressed(Input.Keys.B) && Gdx.input.isKeyPressed(Input.Keys.DOWN)) {
            brightness -= 0.01;
        }
        if (brightness > 0) {
            brightness = 1;
        } else if (brightness < 1) {
            brightness = 0;
        }


    }

    @Override
    public void update(float dt) {
        handleInput();
        Player.setHSV(3, (int)slide.getValue() , 1, 1);
        Player.setHSV(1, (int)slide.getValue()+15 , 1, 1);

    }

    @Override
    public void render(SpriteBatch sb) {

        update(Gdx.graphics.getDeltaTime());
        ClearScreen(Color.TEAL);
        stage.act(Gdx.graphics.getDeltaTime());
        stage.draw();
        sb.begin();
        sb.end();


    }

    @Override
    public void dispose() {

    }
}

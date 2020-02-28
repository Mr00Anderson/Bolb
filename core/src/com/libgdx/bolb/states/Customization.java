package com.libgdx.bolb.states;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.viewport.ExtendViewport;
import com.libgdx.bolb.entities.Player;
import com.libgdx.bolb.management.states.GameStateManager;
import com.libgdx.bolb.management.states.State;
import com.libgdx.bolb.utilities.General;
import com.libgdx.bolb.utilities.UI.SliderButton;
import com.libgdx.bolb.utilities.scene2d.CustomActor;
import static com.libgdx.bolb.utilities.General.ClearScreen;

public class Customization extends State {

    private Stage stage;
    private SliderButton hueSlide, saturationSlide, brightnessSlide;
    private boolean isFinished;
    public static float BRIGHTNESS;
    public static float SATURATION;
    public static int HUE;

    public Customization(GameStateManager gsm) {
        super(gsm);

        hueSlide = new SliderButton(50, 400, 0.0f, 360.0f, 0.1f);
        saturationSlide = new SliderButton(50, 375, 0.0f, 1.0f, 0.001f);
        brightnessSlide = new SliderButton(50, 350, 0.0f, 1.0f, 0.001f);

        Texture play = new Texture("Buttons/Youtube.png");
        stage = new Stage(new ExtendViewport(General.WIDTH, General.HEIGHT));

        final CustomActor next = new CustomActor(new TextureRegion(play), 160, 80, 450, 100);
        next.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                isFinished = true;
            }
        });

        Player.getPlayer().drawbody(stage);
        stage.addActor(hueSlide);
        stage.addActor(saturationSlide);
        stage.addActor(brightnessSlide);
        stage.addActor(next);
        Gdx.input.setInputProcessor(stage);


    }

    @Override
    protected void handleInput() {

        if (isFinished) {
            dispose();
            HUE = (int) hueSlide.getValue();
            SATURATION = saturationSlide.getValue();
            BRIGHTNESS = brightnessSlide.getValue();
            gsm.push(new World(gsm));
        }
    }

    @Override
    public void update(float dt) {
        handleInput();

        stage.getViewport().update(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        Player.getPlayer().update(dt);
        Player.getPlayer().setHSV((int) hueSlide.getValue(), saturationSlide.getValue(), brightnessSlide.getValue());

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

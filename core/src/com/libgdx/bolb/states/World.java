package com.libgdx.bolb.states;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.ParticleEffect;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.ExtendViewport;
import com.libgdx.bolb.entities.Player;
import com.libgdx.bolb.management.states.GameStateManager;
import com.libgdx.bolb.management.states.State;
import com.libgdx.bolb.utilities.CameraUtilities;
import com.libgdx.bolb.utilities.General;

public class World extends State {
    private Stage stage;
    private ExtendViewport viewport;
    private OrthographicCamera cam;


    public World(GameStateManager gsm) {
        super(gsm);
        cam = new OrthographicCamera();
        cam.setToOrtho(false, 1600, 960);
        viewport = new ExtendViewport(General.WIDTH, General.HEIGHT);
        stage = new Stage(viewport);
        Player.getPlayer().drawbody(stage);
        Gdx.input.setInputProcessor(stage);
    }


    @Override
    protected void handleInput() {
        if (Gdx.input.isKeyPressed(Input.Keys.ESCAPE)) {
            Gdx.app.exit();
        }

    }

    @Override
    public void update(float dt) {
        viewport.setCamera(cam);

        handleInput();
        Player.getPlayer().update(dt);

    }

    @Override
    public void render(SpriteBatch sb) {
        update(Gdx.graphics.getDeltaTime());
        Gdx.gl.glClearColor(0.4f, 0.3f, 0.2f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        CameraUtilities.InterpolateToTarget(cam, new Vector2(Player.getPlayer().getPostionX(), Player.getPlayer().getPostionY()));
        cam.update();

        stage.act(Gdx.graphics.getDeltaTime());
        stage.draw();


    }

    @Override
    public void dispose() {
        stage.dispose();
    }
}

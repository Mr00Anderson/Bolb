package com.libgdx.bolb.states;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.ExtendViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.libgdx.bolb.entities.Player;
import com.libgdx.bolb.management.states.GameStateManager;
import com.libgdx.bolb.management.states.State;
import com.libgdx.bolb.utilities.General;

public class World extends State {
    private Stage stage;
    private ExtendViewport viewport;
    private OrthographicCamera cam;

    public World(GameStateManager gsm) {
        super(gsm);
        cam = new OrthographicCamera();
        cam.setToOrtho(false,1600,960);
        viewport = new ExtendViewport(General.WIDTH, General.HEIGHT);
        stage = new Stage(viewport);
        Player.getPlayer().drawbody(stage);
        Gdx.input.setInputProcessor(stage);
    }


    @Override
    protected void handleInput() {
        if(Gdx.input.isKeyPressed(Input.Keys.ESCAPE)){Gdx.app.exit();}

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
        Gdx.gl.glClearColor(0.6f, 0.8f, 1, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        cam.position.set(
                cam.position.x + (Player.getPlayer().getPostionX()- cam.position.x) * 0.075f,
                cam.position.y + (Player.getPlayer().getPostionY()- cam.position.y) * 0.075f,
                0);

        cam.update();
        stage.act(Gdx.graphics.getDeltaTime());
        stage.draw();



    }

    @Override
    public void dispose() {

    }
}

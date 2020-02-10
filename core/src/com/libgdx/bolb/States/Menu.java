package com.libgdx.bolb.States;

import com.badlogic.gdx.Application;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.Logger;
import com.badlogic.gdx.utils.viewport.ExtendViewport;
import com.libgdx.bolb.Management.GameStateManagement.GameStateManager;
import com.libgdx.bolb.Management.GameStateManagement.State;
import com.libgdx.bolb.Utilities.CustomActor;

import static com.badlogic.gdx.scenes.scene2d.actions.Actions.rotateBy;
import static com.libgdx.bolb.Utilities.General.ClearScreen;

public class Menu extends State {

    private static final Logger log = new Logger(Menu.class.getName(), Logger.DEBUG);

    private static final String YOUTUBE = "Buttons/Youtube.png";
    private static final String PLAY = "Buttons/Play.png";


    private Texture Youtube, Play, Info;
    private Stage stage;
    private AssetManager assetManager;

    public Menu(GameStateManager gsm) {
        super(gsm);
        Youtube = new Texture("Buttons/Youtube.png");
        Play = new Texture("Buttons/Play.png");
        Gdx.app.setLogLevel(Application.LOG_DEBUG);
        assetManager = new AssetManager();
//        assetManager.getLogger().setLevel(Logger.DEBUG);


        assetManager.load(YOUTUBE, Texture.class);
        assetManager.load(PLAY, Texture.class);
        // blocks until all resources are loaded into memory
        assetManager.finishLoading();

        // get assets
        Youtube = assetManager.get(YOUTUBE);
        Play = assetManager.get(PLAY);


        final CustomActor Pbutton = new CustomActor(new TextureRegion(Play));
        Pbutton.setSize(160, 80);
        Pbutton.setPosition(100, 200);

        Pbutton.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                Pbutton.clearActions();
                Gdx.app.log("", String.valueOf(x));
                Gdx.app.log("", String.valueOf(y));
                Pbutton.addAction(rotateBy(60, 0.5f));
            }
        });

        final CustomActor Ybutton = new CustomActor(new TextureRegion(Youtube));
        Ybutton.setSize(160, 80);
        Ybutton.setPosition(500, 200);

        Ybutton.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                Ybutton.clearActions();
                Gdx.app.log("", String.valueOf(x));
                Gdx.app.log("", String.valueOf(y));
                Ybutton.addAction(rotateBy(60, 0.5f));
            }
        });

        stage = new Stage(new ExtendViewport(800, 480));
        stage.addActor(Ybutton);
        stage.addActor(Pbutton);
        Gdx.input.setInputProcessor(stage);


    }

    @Override
    protected void HandleInput() {

    }

    @Override
    public void update(float dt) {

    }

    @Override
    public void render(SpriteBatch sb) {
        ClearScreen(Color.LIME);
        stage.act(Gdx.graphics.getDeltaTime());
        stage.draw();

    }

    @Override
    public void dispose() {

    }

}

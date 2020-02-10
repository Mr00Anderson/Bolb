package com.libgdx.bolb.States;

import com.badlogic.gdx.Application;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.Logger;
import com.badlogic.gdx.utils.viewport.ExtendViewport;
import com.libgdx.bolb.Management.GameStateManagement.GameStateManager;
import com.libgdx.bolb.Management.GameStateManagement.State;
import com.libgdx.bolb.Utilities.Scene2dUtilities.CustomActor;
import com.libgdx.bolb.Utilities.Scene2dUtilities.CustomAnimation;

import static com.badlogic.gdx.scenes.scene2d.actions.Actions.fadeIn;
import static com.badlogic.gdx.scenes.scene2d.actions.Actions.fadeOut;
import static com.badlogic.gdx.scenes.scene2d.actions.Actions.rotateBy;
import static com.libgdx.bolb.Utilities.General.ClearScreen;

public class Menu extends State {

    private static final Logger log = new Logger(Menu.class.getName(), Logger.DEBUG);

    private static final String YOUTUBE = "Buttons/Youtube.png";
    private static final String PLAY = "Buttons/Play.png";
    private static final String BLOB = "Entities/BlobAnimation.png";


    private Texture Youtube, Play, Blob;
    private Stage stage;
    private AssetManager assetManager;

    public Menu(final GameStateManager gsm) {
        super(gsm);
        Gdx.app.setLogLevel(Application.LOG_DEBUG);
        assetManager = new AssetManager();
//        assetManager.getLogger().setLevel(Logger.DEBUG);

        assetManager.load(BLOB, Texture.class);
        assetManager.load(YOUTUBE, Texture.class);
        assetManager.load(PLAY, Texture.class);
        // blocks until all resources are loaded into memory
        assetManager.finishLoading();

        // get assets
        Blob = assetManager.get(BLOB);
        Youtube = assetManager.get(YOUTUBE);
        Play = assetManager.get(PLAY);


        final CustomActor Pbutton = new CustomActor(new TextureRegion(Play),160,80,100,200);
        Pbutton.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                Pbutton.clearActions();
                Pbutton.addAction(rotateBy(60, 0.5f));
            }
        });

        final CustomActor Ybutton = new CustomActor(new TextureRegion(Youtube),160,80,500,200);
        Ybutton.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                Ybutton.clearActions();
                Ybutton.addAction(rotateBy(60, 0.5f));
            }
        });


        final CustomAnimation YAnimation = new CustomAnimation(new TextureRegion(Blob),3,0.4f,160,90,300,300);
        YAnimation.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                YAnimation.clearActions();

            }
        });



        stage = new Stage(new ExtendViewport(800, 480));
        stage.addActor(Ybutton);
        stage.addActor(Pbutton);
        stage.addActor(YAnimation);
        Gdx.input.setInputProcessor(stage);


    }

    @Override
    protected void HandleInput() {
        if(Gdx.input.isKeyPressed(Input.Keys.ESCAPE)){Gdx.app.exit();}
    }

    @Override
    public void update(float dt) {
        HandleInput();
    }

    @Override
    public void render(SpriteBatch sb) {
        update(Gdx.graphics.getDeltaTime());
        ClearScreen(Color.LIME);
        stage.act(Gdx.graphics.getDeltaTime());
        stage.draw();

    }

    @Override
    public void dispose() {
    stage.dispose();
    assetManager.dispose();
    }

}

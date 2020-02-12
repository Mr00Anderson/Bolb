package com.libgdx.bolb.states;

import com.badlogic.gdx.Application;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.Logger;
import com.badlogic.gdx.utils.viewport.ExtendViewport;
import com.libgdx.bolb.management.BolbManager;
import com.libgdx.bolb.management.states.GameStateManager;
import com.libgdx.bolb.management.states.State;
import com.libgdx.bolb.utilities.General;
import com.libgdx.bolb.utilities.scene2d.CustomActor;
import com.libgdx.bolb.utilities.scene2d.CustomAnimation;

import static com.badlogic.gdx.scenes.scene2d.actions.Actions.fadeIn;
import static com.badlogic.gdx.scenes.scene2d.actions.Actions.fadeOut;
import static com.badlogic.gdx.scenes.scene2d.actions.Actions.rotateBy;
import static com.libgdx.bolb.utilities.General.ClearScreen;

public class Menu extends State {

	private static final Logger log = new Logger(Menu.class.getName(), Logger.DEBUG);

	private Texture youtube, play, blob;
	private Stage stage;

	public Menu(final GameStateManager gsm) {
		super(gsm);
		Gdx.app.setLogLevel(Application.LOG_DEBUG);

		gsm.assetManager.loadMenu();

		// get assets
		blob = gsm.assetManager.get(BolbManager.BLOB);
		youtube = gsm.assetManager.get(BolbManager.YOUTUBE);
		play = gsm.assetManager.get(BolbManager.PLAY);

		ClickListener listener = menuListener();

		final CustomActor Pbutton = new CustomActor(new TextureRegion(play), 160, 80, 100, 200, true);
		Pbutton.setName("play");
		Pbutton.addListener(listener);

		final CustomActor Ybutton = new CustomActor(new TextureRegion(youtube), 160, 80, 500, 200);
		Ybutton.setName("youtube");
		Ybutton.addListener(listener);

		final CustomAnimation YAnimation = new CustomAnimation(new TextureRegion(blob), 3, 0.4f, 160, 90, 300, 300);
		YAnimation.setName("blob");
		YAnimation.addListener(listener);

		stage = new Stage(new ExtendViewport(General.WIDTH, General.HEIGHT));
		stage.addActor(Ybutton);
		stage.addActor(Pbutton);
		stage.addActor(YAnimation);
		Gdx.input.setInputProcessor(stage);

	}

	private ClickListener menuListener() {
		ClickListener listener = new ClickListener() {

			@Override
			public void clicked(InputEvent event, float x, float y) {
				Actor actor = event.getListenerActor();
				switch (actor.getName()) {
				case "play":
					actor.clearActions();
					actor.addAction(rotateBy(60, 0.5f));
					break;
				case "youtube":
					actor.clearActions();
					actor.addAction(rotateBy(60, 0.5f));
					break;
				case "blob":
					actor.clearActions();
					break;
				}
			}
		};

		return listener;
	}

	@Override
	protected void handleInput() {
		if (Gdx.input.isKeyPressed(Input.Keys.ESCAPE)) {
			Gdx.app.exit();
		}
	}

	@Override
	public void update(float dt) {
		handleInput();
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
		youtube.dispose();
		play.dispose();
		blob.dispose();
		stage.dispose();
		gsm.assetManager.disposeMenu();
	}

}

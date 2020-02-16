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
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
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

	private Texture settings, play, blob;
	private Stage stage;

	

	
	
	public Menu(final GameStateManager gsm) {
		super(gsm);
		Gdx.app.setLogLevel(Application.LOG_DEBUG);

		gsm.assetManager.loadMenu();

		// get assets
		blob = gsm.assetManager.get(BolbManager.BLOB);
		settings = gsm.assetManager.get(BolbManager.SETTINGS);
		play = gsm.assetManager.get(BolbManager.PLAY);

		ClickListener listener = menuListener();

		
		final CustomActor playButton = new CustomActor(new TextureRegion(play), play.getWidth()*4, play.getHeight()*4, -play.getWidth() - 100, settings.getHeight(), true);
		playButton.addAction(Actions.moveTo(10, settings.getHeight(), 0.5f));
		playButton.setName("play");
		playButton.addListener(listener);

		final CustomActor settingsButton = new CustomActor(new TextureRegion(settings), settings.getWidth(), settings.getHeight(), General.WIDTH + settings.getWidth(), settings.getHeight());
		settingsButton.addAction(Actions.moveTo(General.WIDTH - settings.getWidth() - 10, settings.getHeight(), 0.5f));
		settingsButton.setName("settings");
		settingsButton.addListener(listener);

		final CustomAnimation YAnimation = new CustomAnimation(new TextureRegion(blob), 3, 0.4f, 160, 90, 300, 300);
		YAnimation.setName("blob");
		YAnimation.addListener(listener);

		stage = new Stage(new ExtendViewport(General.WIDTH, General.HEIGHT));
		stage.addActor(settingsButton);
		stage.addActor(playButton);
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
				case "settings":
					actor.clearActions();
					actor.addAction(rotateBy(60, 0.5f));
					gsm.push(new Settings(gsm));
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
		settings.dispose();
		play.dispose();
		blob.dispose();
		stage.dispose();
		gsm.assetManager.disposeMenu();
	}

}

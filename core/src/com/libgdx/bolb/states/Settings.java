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

public class Settings extends State {

	private static final Logger log = new Logger(Settings.class.getName(), Logger.DEBUG);

	private Texture back, blob;
	private Stage stage;

	public Settings(final GameStateManager gsm) {
		super(gsm);
		Gdx.app.setLogLevel(Application.LOG_DEBUG);

		gsm.assetManager.loadMenu();

		// get assets
		blob = gsm.assetManager.get(BolbManager.BLOB);
		back = gsm.assetManager.get(BolbManager.SETTINGS);

		ClickListener listener = menuListener();

		final CustomActor backButton = new CustomActor(new TextureRegion(back), back.getWidth(), back.getHeight(), General.WIDTH - back.getWidth() - 10, back.getHeight(), true);
		backButton.addAction(Actions.moveTo(10, back.getHeight(), 0.5f));
		backButton.setName("back");
		backButton.addListener(listener);

		final CustomAnimation YAnimation = new CustomAnimation(new TextureRegion(blob), 3, 0.4f, 160, 90, 300, 300);
		YAnimation.setName("blob");
		YAnimation.addListener(listener);

		stage = new Stage(new ExtendViewport(General.WIDTH, General.HEIGHT));

		stage.addActor(backButton);
		stage.addActor(YAnimation);
		Gdx.input.setInputProcessor(stage);

	}

	private ClickListener menuListener() {
		ClickListener listener = new ClickListener() {

			@Override
			public void clicked(InputEvent event, float x, float y) {
				Actor actor = event.getListenerActor();
				switch (actor.getName()) {
				case "back":
					gsm.push(new Menu(gsm));
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
		back.dispose();
		blob.dispose();
		stage.dispose();
		gsm.assetManager.disposeMenu();
	}

}

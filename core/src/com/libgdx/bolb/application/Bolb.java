package com.libgdx.bolb.application;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.libgdx.bolb.management.states.GameStateManager;
import com.libgdx.bolb.states.Menu;

public class Bolb extends ApplicationAdapter {
	private SpriteBatch batch;
	private GameStateManager gsm;

	@Override
	public void create() {
		batch = new SpriteBatch();
		gsm = new GameStateManager();
		gsm.push(new Menu(gsm));
	}

	@Override
	public void render() {
		gsm.update(Gdx.graphics.getDeltaTime());
		gsm.render(batch);
	}

	@Override
	public void dispose() {
		batch.dispose();
	}
}

package com.libgdx.bolb.management;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.Texture;

public class BolbManager extends AssetManager {

	public static final String YOUTUBE = "Buttons/Youtube.png";
	public static final String PLAY = "Buttons/Play.png";
	public static final String BLOB = "Entities/BlobAnimation.png";

	public BolbManager() {
//      assetManager.getLogger().setLevel(Logger.DEBUG);
	}

	public void loadMenu() {
		load(BLOB, Texture.class);
		load(YOUTUBE, Texture.class);
		load(PLAY, Texture.class);
		// blocks until all resources are loaded into memory
		finishLoading();
	}

	public void disposeMenu() {
		unloadAsset(BLOB);
		unloadAsset(YOUTUBE);
		unloadAsset(PLAY);
	}

	private void unloadAsset(String asset) {
		if (isLoaded(asset)) {
			for (int i = getReferenceCount(asset); i > 0; --i)
				unload(asset);
			finishLoading();
			Gdx.app.log("BolbManager", "Unloaded: " + asset);
		}
	}
}

package com.libgdx.bolb.management;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.AssetDescriptor;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.utils.Logger;

public class BolbManager extends AssetManager {

	public static final AssetDescriptor<Texture> YOUTUBE = new AssetDescriptor<Texture>("Buttons/Youtube.png", Texture.class);
	public static final AssetDescriptor<Texture> PLAY = new AssetDescriptor<Texture>("Buttons/Play.png", Texture.class);
	public static final AssetDescriptor<Texture> BLOB = new AssetDescriptor<Texture>("Entities/BlobAnimation.png", Texture.class);

	public BolbManager() {
     BolbManager.this.getLogger().setLevel(Logger.DEBUG);
	}

	public void loadMenu() {
		load(BLOB);
		load(YOUTUBE);
		load(PLAY);
		// blocks until all resources are loaded into memory
		finishLoading();
	}

	public void disposeMenu() {
		unloadAsset(BLOB);
		unloadAsset(YOUTUBE);
		unloadAsset(PLAY);
	}

	private void unloadAsset(AssetDescriptor asset) {
		if (isLoaded(asset.fileName)) {
			for (int i = getReferenceCount(asset.fileName); i > 0; --i)
				unload(asset.fileName);
			finishLoading();
			Gdx.app.log("BolbManager", "Unloaded: " + asset);
		}
	}
}

package com.libgdx.bolb.management;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.AssetDescriptor;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.utils.Logger;

public class BolbManager extends AssetManager {

    public static final AssetDescriptor<Texture> YOUTUBE = new AssetDescriptor<Texture>("Buttons/Youtube.png", Texture.class);
    public static final AssetDescriptor<Texture> PLAY = new AssetDescriptor<Texture>("Buttons/Rapier.png", Texture.class);
    public static final AssetDescriptor<Texture> SETTINGS = new AssetDescriptor<Texture>("Buttons/Sword2.png", Texture.class);
    public static final AssetDescriptor<Texture> BLOB = new AssetDescriptor<Texture>("Entities/BlobAnimation.png", Texture.class);

    //Player
    public static final AssetDescriptor<Texture> Body = new AssetDescriptor<Texture>("Entities/Player/Torso/Character-Animation.png", Texture.class);
    public static final AssetDescriptor<Texture> Eyes = new AssetDescriptor<Texture>("Entities/Player/Eyes/Eyes-Animation.png", Texture.class);
    public static final AssetDescriptor<Texture> Lighting = new AssetDescriptor<Texture>("Entities/Player/Lighting-Animation.png", Texture.class);

    public static final AssetDescriptor<Texture> DefaultHair = new AssetDescriptor<Texture>("Entities/Player/Hair/Default-Hair.png", Texture.class);
    public static final AssetDescriptor<Texture> DefaultHairShine = new AssetDescriptor<Texture>("Entities/Player/Hair/Default-Hair-Shine.png", Texture.class);
    public static final AssetDescriptor<Texture> JesterHair = new AssetDescriptor<Texture>("Entities/Player/Hair/Jester-Hair.png", Texture.class);
    public static final AssetDescriptor<Texture> JesterHairShine = new AssetDescriptor<Texture>("Entities/Player/Hair/Jester-Hair-Shine.png", Texture.class);
    public static final AssetDescriptor<Texture> Bald = new AssetDescriptor<Texture>("Entities/Player/Hair/Bald.png", Texture.class);
    public static final AssetDescriptor<Texture> BaldShine = new AssetDescriptor<Texture>("Entities/Player/Hair/Bald-Shine.png", Texture.class);

    public BolbManager() {
        BolbManager.this.getLogger().setLevel(Logger.DEBUG);
    }

    public void loadMenu() {
        load(BLOB);
        load(YOUTUBE);
        load(SETTINGS);
        load(PLAY);
        // blocks until all resources are loaded into memory
        finishLoading();
    }

    public void loadPlayer() {
        load(DefaultHair);
        load(DefaultHairShine);
        load(JesterHair);
        load(JesterHairShine);
        load(Bald);
        load(BaldShine);
        load(Body);
        load(Eyes);
        load(Lighting);
        // blocks until all resources are loaded into memory
        finishLoading();
    }

    public void disposeMenu() {
        unloadAsset(BLOB);
        unloadAsset(YOUTUBE);
        unloadAsset(SETTINGS);
        unloadAsset(PLAY);
    }

    private void unloadAsset(AssetDescriptor<?> asset) {
        if (isLoaded(asset.fileName)) {
            for (int i = getReferenceCount(asset.fileName); i > 0; --i)
                unload(asset.fileName);
            finishLoading();
            Gdx.app.log("BolbManager", "Unloaded: " + asset);
        }
    }
}

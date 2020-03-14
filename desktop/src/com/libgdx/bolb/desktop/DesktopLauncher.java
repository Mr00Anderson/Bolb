package com.libgdx.bolb.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.libgdx.bolb.application.Bolb;

import static com.libgdx.bolb.utilities.General.HEIGHT;
import static com.libgdx.bolb.utilities.General.TITLE;
import static com.libgdx.bolb.utilities.General.WIDTH;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
//		config.foregroundFPS = FPS;
//		config.backgroundFPS = FPS;
		config.vSyncEnabled = true;
		config.title = TITLE;
		config.width = WIDTH;
		config.height = HEIGHT;
//		config.fullscreen = true;
		new LwjglApplication(new Bolb(), config);
	}
}

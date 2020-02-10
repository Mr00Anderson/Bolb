package com.libgdx.bolb.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.libgdx.bolb.Bolb.Bolb;

import static com.libgdx.bolb.Utilities.General.FPS;
import static com.libgdx.bolb.Utilities.General.HEIGHT;
import static com.libgdx.bolb.Utilities.General.TITLE;
import static com.libgdx.bolb.Utilities.General.WIDTH;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.foregroundFPS = FPS;
		config.backgroundFPS = FPS;
		config.title = TITLE;
		config.width = WIDTH;
		config.height = HEIGHT;
		new LwjglApplication(new Bolb(), config);
	}
}

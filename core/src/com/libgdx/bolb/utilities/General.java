package com.libgdx.bolb.utilities;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;

public class General {

    public static final String TITLE = "Bolb";
    public static final int WIDTH = 800;
    public static final int HEIGHT = 480;
    public static final int FPS = 60;

    public static void ClearScreen() {
        //Clear screen to black
        ClearScreen(Color.BLACK);

    }

    public static void ClearScreen(Color color) {
        //Clear screen to desired color
        Gdx.gl.glClearColor(color.r, color.g, color.b, color.a);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);


    }

}

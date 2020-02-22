package com.libgdx.bolb.utilities.UI;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Slider;
import com.badlogic.gdx.scenes.scene2d.ui.Touchpad;
import com.badlogic.gdx.scenes.scene2d.utils.Drawable;

public class SliderButton extends Slider {

    private static SliderStyle sliderStyle;
    private static Skin sliderSkin;
    private static Drawable sliderBackground;
    private static Drawable sliderKnob;

    public SliderButton(int x, int y) {
        super(0.0f, 360.0f, 0.1f, false, getSliderStyle());
        setBounds(15, 15, 700, 100);
        setPosition(x,y);
    }


    private static SliderStyle getSliderStyle() {
        //We need the skin to get the drawables for the SliderStyle
        sliderSkin = new Skin();
        sliderSkin.add("touchBackground", new Texture("Buttons/Play.png"));

        sliderSkin.add("touchKnob", new Texture("Buttons/Youtube.png"));

        sliderStyle = new SliderStyle();

        sliderBackground = sliderSkin.getDrawable("touchBackground");
        sliderKnob = sliderSkin.getDrawable("touchKnob");

        sliderStyle.background = sliderBackground;
        sliderStyle.knob = sliderKnob;

        return sliderStyle;
    }
}

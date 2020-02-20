package com.libgdx.bolb.entities;

import com.badlogic.gdx.scenes.scene2d.Stage;

public class player {

    private com.libgdx.bolb.entities.body body;
    private lighting lighting;
    private eyes eyes;
    private hair hair;



    public player() {
        body = new body();
        eyes = new eyes();
        lighting = new lighting();
        hair = new hair();
    }

    public void update(float dt){


    }

    public void drawbody(Stage stage){
        stage.addActor(body);
        stage.addActor(lighting);
        stage.addActor(eyes);
        stage.addActor(hair);
    }

    public void setHSV(int part, int hue,float saturation, float brightness){
        if(part == 1){
            this.lighting.setHSV(hue,saturation,brightness);}
        else if (part == 2){
            this.hair.setHSV(hue,saturation,brightness);
        }
        else if (part == 3){
            this.body.setHSV(hue,saturation,brightness);
        }
        else if (part == 4){
            this.eyes.setHSV(hue,saturation,brightness);
        }

    }
}

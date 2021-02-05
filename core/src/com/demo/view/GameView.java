package com.demo.view;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.demo.demo.Kouchu;

public class GameView extends Group {
    public GameView(){
//        ShowImage show = new ShowImage();
//        addActor(show);

//        PolyShowShape demo01 = new PolyShowShape();
//        addActor(demo01);

        TextureRegion region = new TextureRegion( new Texture("1.jpg"));
//        Image image = new Image(region);
//        addActor(image);
        TextureRegion[][] split = region.split(100, 100);
//        Kouchu demo02 = new Kouchu(region);
//
//        addActor(demo02);

//        for (TextureRegion[] textureRegions : split) {
//            for (TextureRegion textureRegion : textureRegions) {
//                Kouchu demo02 = new Kouchu(region);
//                addActor(demo02);
//            }
//        }


        int index = 0;

        for (int i = 0; i < split.length; i++) {
            for (int i1 = 0; i1 < split[0].length; i1++) {
                Kouchu demo02 = new Kouchu(region,i,i1);
                addActor(demo02);
                index++;
            }
        }



//        region.setRegion(200,200,200,200);
//        Kouchu demo03 = new Kouchu(region);
//        addActor(demo03);
//        ShowGray gray = new ShowGray();
//        addActor(gray);
    }
}

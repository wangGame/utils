package com.demo.view;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Group;

public class GameView extends Group {
    TextureRegion[][] split;
    public GameView(){
//        ShowImage show = new ShowImage();
//        addActor(show);

//        PolyShowShape demo01 = new PolyShowShape();
//        addActor(demo01);

        TextureRegion region = new TextureRegion( new Texture("1.jpg"));
//        Image image = new Image(region);
//        addActor(image);
        split = region.split(100, 100);
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

//        for (int i = 0; i < split.length; i++) {
//            for (int i1 = 0; i1 < split[0].length; i1++) {
//                Kouchu demo02 = new Kouchu(region,i,i1);
//                demo02.setPosition(0,0);
//                addActor(demo02);
//                index++;
//            }
//        }



//        region.setRegion(200,200,200,200);
//        Kouchu demo03 = new Kouchu(region);
//        addActor(demo03);
//        ShowGray gray = new ShowGray();
//        addActor(gray);
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        super.draw(batch, parentAlpha);
        int i=0;
        int j = 0;

        for (TextureRegion[] textureRegions : split) {
            i++;
            j=0;
            for (TextureRegion textureRegion : textureRegions) {
                j++;
                batch.draw(textureRegion,i*100,j*100);
            }
        }

    }
}

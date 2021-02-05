package com.demo.demo;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.ui.Image;

/**
 *  顯示图片
 */
public class ShowImage extends Image {
    public ShowImage(){
        super(new TextureRegion(new Texture("1.png")));
    }
    public void draw(Batch batch, float parentAlpha) {
        super.draw(batch,parentAlpha);
    }
}

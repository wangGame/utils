package com.demo.demo;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.glutils.ShaderProgram;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.ui.Image;

/**
 * 显示轮廓
 */
public class ShowGray extends Group {
    private ShaderProgram program;
    public ShowGray(){
        program = new ShaderProgram(
                Gdx.files.internal("shader/gray.vert"),
                Gdx.files.internal("shader/gray.frag"));

        Image image = new Image(new Texture("0000.png"));
        addActor(image);
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        batch.setShader(program);
        super.draw(batch,parentAlpha);
        batch.setShader(null);
    }
}

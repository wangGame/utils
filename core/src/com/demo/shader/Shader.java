package com.demo.shader;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.glutils.ShaderProgram;
import com.badlogic.gdx.scenes.scene2d.ui.Image;

public class Shader extends Image {

    ShaderProgram program;
    public Shader(){
        super(new Texture("1.png"));
        program = new ShaderProgram(
                Gdx.files.internal("shader/demo.vert"),
                Gdx.files.internal("shader/demo.frag"));
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        batch.setShader(program);
        super.draw(batch, parentAlpha);
        batch.setShader(null);
    }
}

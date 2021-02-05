package com.demo.demo;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.glutils.ShaderProgram;
import com.badlogic.gdx.scenes.scene2d.Group;

/**
 * 从图片中扣出一块区域
 */
public class Kouchu extends Group {
    Texture other;
    TextureRegion region;
    float xx = 0;
    private ShaderProgram shader;
    public Kouchu(){
        shader = new ShaderProgram(
                Gdx.files.internal("shader/circle.vert"),
                Gdx.files.internal("shader/circle.frag"));
        other =new Texture("0000.png");
        setSize(720,1280);  //white_circle
        region = new TextureRegion( new Texture("1.png"));
    }

    @Override
    public void act(float delta) {
        super.act(delta);
        if (Gdx.input.isKeyPressed(Input.Keys.LEFT)){
            xx -= 0.1F;
        }
        if (Gdx.input.isKeyPressed(Input.Keys.RIGHT)){
            xx += 0.1F;
        }
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        batch.flush();
        shader.begin();
        Gdx.gl.glActiveTexture(GL20.GL_TEXTURE1);
        other.bind();
        shader.setUniformi("u_texture2",1);
        shader.setUniformf("u_scale",0.56F+xx);
        shader.setUniformf("v_scale",1+xx);
        Gdx.gl.glActiveTexture(GL20.GL_TEXTURE0);
        region.getTexture().bind();
        shader.setUniformMatrix("u_projTrans",batch.getProjectionMatrix());
        batch.draw(region,getX(),getY(),originX,originY,region.getRegionWidth(),
                region.getRegionHeight(),0.95F*getScaleX(),0.95F*getScaleY(),1);
        batch.flush();
        shader.end();
    }
}

package com.demo.demo;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.glutils.ShaderProgram;
import com.badlogic.gdx.scenes.scene2d.Actor;

/**
 * 从图片中扣出一块区域
 */
public class Kouchu extends Actor {
    Texture other;
    TextureRegion region;
    float xx = 0;
    private ShaderProgram shader;
    float i=0;
    float i1 = 0;
    public Kouchu(TextureRegion region, int i, int i1){
        this.i = i;
        this.i1 = i1;
        this.region = region;
        shader = new ShaderProgram(
                Gdx.files.internal("shader/circle.vert"),
                Gdx.files.internal("shader/circle.frag"));
        other =new Texture("0000.png");
        setSize(region.getRegionWidth(),region.getRegionHeight());  //white_circle
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        batch.flush();
        batch.setShader(shader);
        shader.begin();
        Gdx.gl.glActiveTexture(GL20.GL_TEXTURE1);
        other.bind();
        shader.setUniformi("u_texture2",1);
        // kuan
        shader.setUniformf("u_scale",(float) other.getWidth()/region.getTexture().getWidth());
        shader.setUniformf("v_scale",(float) other.getHeight()/region.getTexture().getHeight());
        shader.setUniformf("v_x",100.0F*i1 /region.getTexture().getWidth());
        shader.setUniformf("v_y",100.0F*i /region.getTexture().getHeight());

        Gdx.gl.glActiveTexture(GL20.GL_TEXTURE0);
        region.getTexture().bind();
        batch.draw(region,getX(),getY(),0,0,region.getRegionWidth(),
                region.getRegionHeight(),getScaleX(),getScaleY(),1);
        batch.flush();
        shader.end();
        batch.setShader(null);
    }
}

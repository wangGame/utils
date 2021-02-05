package com.demo.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputMultiplexer;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.demo.MainGame;
import com.demo.view.GameView;

public class GameScreen implements Screen {
    private Stage stage;
    private InputMultiplexer inputMultiplexer;
    public GameScreen(MainGame mainGame) {
        inputMultiplexer = new InputMultiplexer();
        stage =  new Stage(mainGame.getViewport(),mainGame.getBatch());
        inputMultiplexer.addProcessor(stage);
        Gdx.input.setInputProcessor(inputMultiplexer);
    }

    @Override
    public void show() {
        GameView view = new GameView();
        stage.addActor(view);
    }

    @Override
    public void render(float delta) {
        stage.act();
        stage.draw();
    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {

    }
}

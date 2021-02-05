package com.demo.view;

import com.badlogic.gdx.scenes.scene2d.Group;
import com.demo.demo.Kouchu;
import com.demo.demo.ShowImage;

public class GameView extends Group {
    public GameView(){
        ShowImage show = new ShowImage();
        addActor(show);

//        PolyShowShape demo01 = new PolyShowShape();
//        addActor(demo01);

        Kouchu demo02 = new Kouchu();
        demo02.setPosition(200,200);
        addActor(demo02);

//        ShowGray gray = new ShowGray();
//        addActor(gray);
    }
}

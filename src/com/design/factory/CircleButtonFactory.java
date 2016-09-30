package com.design.factory;

public class CircleButtonFactory implements ButtonFactory {
    @Override
    public Button createButton() {
        return new CircleButton();
    }

}

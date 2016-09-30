package com.design.factory;

public class RecButtonFactory implements ButtonFactory {
    @Override
    public Button createButton() {
        return new RecButton();
    }
}

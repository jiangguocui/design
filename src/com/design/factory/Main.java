package com.design.factory;

public class Main {
    public static void main(String[] args) {
        ButtonFactory buttonFactory = null;
        buttonFactory = new CircleButtonFactory();
        Button circleButton = buttonFactory.createButton();
        circleButton.print();

        buttonFactory = new RecButtonFactory();
        RecButton recButton = (RecButton) buttonFactory.createButton();
        recButton.print();
    }
}

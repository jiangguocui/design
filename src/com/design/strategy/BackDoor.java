package com.design.strategy;

//初到吴国，找后门
public class BackDoor implements Strategy {

    @Override
    public void operate() {
        System.out.println("找乔国老帮忙，让吴国太给孙权施加压力，使孙权不能杀刘备");

    }

}

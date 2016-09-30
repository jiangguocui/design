package com.design.observer;

public class SubHuman implements ISubScribe {
    private String name;

    public SubHuman(String name) {
        this.name = name;
    }

    @Override
    public void hasNewPaper() {
        System.out.println(name+"!!有新报纸了，请查收！");
    }

}

package com.design.adapter;

public class DogAdapter extends Dog implements Robot{

    @Override
    public void cry() {
       super.wang();
    }

    @Override
    public void move() {
        super.run();
    }
}

package com.design.status;
//打开电视的状态
public class TVStartState implements State{

    @Override
    public void doAction() {
        System.out.println("TV is turned ON");
    }

}

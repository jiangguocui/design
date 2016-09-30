package com.design.factory;

public class RecButton implements Button{

    @Override
    public void print() {
        System.out.println("生产矩形按钮");
    }

}

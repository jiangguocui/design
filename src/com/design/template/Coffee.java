package com.design.template;

public class Coffee extends Beverage {

    @Override
    public void addCoundiments() {
        System.out.println("添加糖和牛奶");

    }

    @Override
    public void brew() {
        System.out.println("用水冲咖啡");

    }

}

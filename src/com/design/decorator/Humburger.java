package com.design.decorator;

//汉堡基类
public abstract class Humburger {
    protected String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    public abstract double getPrice();
}

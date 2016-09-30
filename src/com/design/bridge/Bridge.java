package com.design.bridge;

//一个桥
public abstract class Bridge {
    private Sourceable source;
    public abstract void method();
    public Sourceable getSource() {
        return source;
    }
    public void setSource(Sourceable source) {
        this.source = source;
    }
    
}

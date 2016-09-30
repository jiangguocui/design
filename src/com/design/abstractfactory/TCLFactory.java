package com.design.abstractfactory;
//TCL工厂
public class TCLFactory implements ElecFactory{

    @Override
    public Electric createTV() {
        return new TCLTV();
    }

    @Override
    public Electric createRefrigerator() {
        return new TCLRefrigerator();
    }

}

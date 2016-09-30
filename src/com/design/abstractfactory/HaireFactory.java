package com.design.abstractfactory;
//海尔工厂
public class HaireFactory implements  ElecFactory{

    @Override
    public Electric createTV() {
        return new HaierTV();
    }

    @Override
    public Electric createRefrigerator() {
        return new HaireRefrigerator();
    }

}

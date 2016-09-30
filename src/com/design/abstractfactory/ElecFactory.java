package com.design.abstractfactory;
//电器工厂
public interface ElecFactory {
    //生产电视
    public Electric createTV();
    
    //生产冰箱
    public Electric createRefrigerator();
}

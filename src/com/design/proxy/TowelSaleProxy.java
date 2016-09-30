package com.design.proxy;

public class TowelSaleProxy implements SaleTowelIntertace{
    //毛巾生产类
    private TowelProduce tp;
    TowelSaleProxy( String consumerName) {
       tp = new TowelProduce(consumerName);
        
    }
    @Override
    public void sellTowel() {
        tp.sellTowel();
        
    }

}

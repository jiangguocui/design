package com.design.proxy;

//毛巾生产
public class TowelProduce implements SaleTowelIntertace {
    private String consumerName;

    public TowelProduce(String consumerName) {
        this.consumerName = consumerName;
    }

    @Override
    public void sellTowel() {
        System.out.println("毛巾卖给了"+consumerName);
    }

}

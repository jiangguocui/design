package com.design.proxy;

public class Main {
    public static void main(String[] args) {
        SaleTowelIntertace saleTowelIntertace = new TowelSaleProxy("张三");
        saleTowelIntertace.sellTowel();
    }
}

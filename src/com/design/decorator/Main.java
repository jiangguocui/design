package com.design.decorator;

public class Main {
    public static void main(String[] args) {
        // 鸡腿堡
        Humburger humburger = new ChickenBurger();
        System.out.println(humburger.getName() + "  价钱：" + humburger.getPrice());
        // 加辣椒
        Humburger chilli = new Chilli(humburger);
        System.out.println(chilli.getName() + "  价钱：" + chilli.getPrice());
        // 加生菜的堡
        Humburger lettuce = new Lettuce(humburger);
        System.out.println(lettuce.getName() + "  价钱：" + lettuce.getPrice());
    }
}

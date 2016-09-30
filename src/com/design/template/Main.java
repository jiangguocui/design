package com.design.template;

public class Main {
    public static void main(String[] args) {
        Beverage coffee = new Coffee();  
        coffee.create();//冲泡咖啡
        System.out.println("-----------------------------------");
        Beverage tea = new Tea();
        tea.create();//冲茶
    }
}

package com.design.builder;

public class Main {
    public static void main(String[] args) {
        //服务员  
        KFCWaiter waiter = new KFCWaiter();  
        //套餐A  
        MealA a = new MealA();  
        //服务员准备套餐A  
        waiter.setMealBuilder(a);  
        //获得套餐  
        Meal mealA = waiter.construct();  
          
        System.out.print("套餐A的组成部分:");  
        System.out.println(mealA.getFood()+"---"+mealA.getDrink());  
        
        //套餐B
        MealB b = new MealB();
        waiter.setMealBuilder(b);
        Meal mealB=waiter.construct();
        System.out.print("套餐B的组成部分:");  
        System.out.println(mealB.getFood()+"---"+mealB.getDrink());  
    }
}

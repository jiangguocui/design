package com.design.builder;
//套餐A
public class MealA extends MealBuilder{

    @Override
    public void buildFood() {
       meal.setFood("一盒薯条");
        
    }

    @Override
    public void buildDrink() {
        meal.setDrink("一杯可乐");
    }

}

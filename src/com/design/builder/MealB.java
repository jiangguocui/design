package com.design.builder;
//套餐B
public class MealB extends MealBuilder {

    @Override
    public void buildFood() {
        meal.setFood("一只全鸡");
    }

    @Override
    public void buildDrink() {
        meal.setDrink("一杯橙汁");
    }

}

package com.design.builder;

//肯德基服务员，相当于一个指挥者
public class KFCWaiter {
    private MealBuilder mealBuilder;

    public void setMealBuilder(MealBuilder mealBuilder) {
        this.mealBuilder = mealBuilder;
    }
    
    public Meal construct(){  
        //准备食物  
        mealBuilder.buildFood();  
        //准备饮料  
        mealBuilder.buildDrink();  
          
        //准备完毕，返回一个完整的套餐给客户  
        return mealBuilder.getMeal();  
    }  
}

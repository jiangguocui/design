package com.design.strategy;

//求吴国太开绿灯放行
public class GivenGreenLight implements Strategy {

    @Override
    public void operate() {
        System.out.println("求吴国太开个绿灯，放行");

    }

}

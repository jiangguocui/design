package com.design.observer;

public class Main {
    public static void main(String[] args) {
        INewsPaper paper = new PeopleNewsPaper();
        SubHuman xiaoMing = new SubHuman("小民");
        SubHuman zhangSan = new SubHuman("张三");
        SubHuman liSi = new SubHuman("李四");
        //小明订报
        paper.RegisterSubscriber(xiaoMing);
        paper.RegisterSubscriber(zhangSan);
        paper.RegisterSubscriber(liSi);
        paper.SendPaper();
        System.out.println("-------------发完报纸了-------------");
        
        paper.RemoveSubScriber(xiaoMing);
        
        paper.SendPaper();
        
    }
}

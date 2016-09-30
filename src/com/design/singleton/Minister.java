package com.design.singleton;

//大臣
public class Minister {
    public static void main(String[] args) {
        for (int day = 0; day < 3; day++) {
            Emperor emperor = Emperor.getInstance();
            emperor.say();
        }
        //三天见的皇帝都是同一人，荣幸吧
    }
}

package com.design.singleton;

public class Emperor {
    // 初始化一个皇帝
    private static final Emperor emperor = new Emperor();

    // 世俗和道德约束你，目的就是不希望产生第二个皇帝
    private Emperor() {
    };

    public static Emperor getInstance() {
        return emperor;
    }

    // 皇帝发话
    public static void say() {
        System.out.println("有事启奏，无事退朝");
    }
}

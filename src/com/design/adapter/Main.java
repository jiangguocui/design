package com.design.adapter;

public class Main {
    public static void main(String[] args) {
        //机器狗产生了
        Robot dogRobot = new DogAdapter();
        dogRobot.cry();
        dogRobot.move();
    }
}

package com.design.abstractfactory;

public class Main {
    public static void main(String[] args) {
        //海尔工厂生产线
        HaireFactory haireFactory = new HaireFactory();
        //TCL工厂生产线
        TCLFactory tclFactory = new TCLFactory();
        
        //开始生产电器啦
        Electric haireTV = haireFactory.createTV();
        Electric haireRefrigerator = haireFactory.createRefrigerator();
        
        Electric tclTV = tclFactory.createTV();
        Electric tclRefrigerator = tclFactory.createRefrigerator();
        
        haireTV.printProduct();
        haireRefrigerator.printProduct();
        tclTV.printProduct();
        tclRefrigerator.printProduct();
        
    }
}

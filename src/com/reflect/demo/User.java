package com.reflect.demo;

@MyAnnotation(name="someName",  value = "Hello World")
public class User {
    private int id;

    private String name;

    private int age;
    
    public int sex;
    
    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    @MyAnnotation(name="method",  value = "Hello World")
    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    private User(int id) {
        this.id = id;
    }

    public  User() {
    };

    public  User(String name) {
        this.name = name;
    }
    
    private String getHelloString(){
        return "hello";
    }
}

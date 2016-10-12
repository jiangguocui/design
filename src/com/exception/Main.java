package com.exception;

import org.springframework.http.HttpStatus;

public class Main {
public static void main(String[] args) {
    try {
        int i =1/0;
    } catch (Exception e) {
       System.out.println("divide can not be 0");
       throw new MyException("ERROR", "divide can not be 0", HttpStatus.BAD_REQUEST);
    }
}
}

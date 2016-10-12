package com.exception;

import org.springframework.http.HttpStatus;
import org.springframework.util.StringUtils;

public class Main {
public static void main(String[] args) {
    
    int count = 0;
    for(int i =0;i<10;i++){
        count = count++;
    }
    System.out.println(count);
    String str = null;
    assert str != null :"null";
    
    Integer.valueOf(10);
    Long.valueOf(10L);
    Double.valueOf(10);
    
    try {
        int i =1/0;
    } catch (Exception e) {
       System.out.println("divide can not be 0");
       throw new MyException("ERROR", "divide can not be 0", HttpStatus.BAD_REQUEST);
    }
}
}

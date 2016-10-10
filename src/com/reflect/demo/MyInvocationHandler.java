package com.reflect.demo;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class MyInvocationHandler  implements InvocationHandler {
    Object obj = null;
    public  MyInvocationHandler(Object _obj) {
        this.obj = _obj;
    }
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        // TODO Auto-generated method stub
        System.out.println("before....................");
        Object result = method.invoke(this.obj, args);
        System.out.println("after.................");
        return result;
    }

}

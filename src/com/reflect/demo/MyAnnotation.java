package com.reflect.demo;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;
import java.lang.annotation.ElementType;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)//表示这个注解可以在运行期通过反射访问。如果你没有在注解定义的时候使用这个指示那么这个注解的信息不会保留到运行期，这样反射就无法获取它的信息。
@Target({ElementType.TYPE,ElementType.METHOD})
public @interface MyAnnotation {
    public String name();

    public String value();

}

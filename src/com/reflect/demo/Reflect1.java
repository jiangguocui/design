package com.reflect.demo;

import java.lang.annotation.Annotation;
import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Proxy;
import java.util.UUID;

public class Reflect1 {
    public static void main(String[] args) throws ClassNotFoundException, InstantiationException,
            IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException,
            InvocationTargetException, NoSuchFieldException {

        // Class 对象
        Class cls = Class.forName("com.reflect.demo.User");
        User u = (User) cls.newInstance();

        // 方法 指定类中声明为公有的(public)的所有变量集合。
        Method[] methods = User.class.getDeclaredMethods();
        for (Method method : methods) {
            System.out.println(method.getName());
        }
        // 你知道你要调用方法的具体参数类型，你就可以直接通过参数类型来获取指定的方法
        Method method = cls.getMethod("setName", new Class[] { String.class });
        System.out.println(method);
        // 方法参数以及返回类型
        Class[] parameterTypes = method.getParameterTypes();
        System.out.println(parameterTypes[0]);
        Class returnatype = method.getReturnType();
        System.out.println(returnatype);
        // 通过Method对象调用方法
        Object object = method.invoke(u, "jgc");
        System.out.println(u.getName());

        // Getters and Setters
        Method[] methods2 = cls.getMethods();
        for (Method method2 : methods2) {
            if (method2.getName().startsWith("get") && method2.getParameterTypes().length == 0
                    && !void.class.equals(method2.getReturnType())) {
                System.out.println("get方法" + method2.getName());
            }

            if (method2.getName().startsWith("set") && method2.getParameterTypes().length >= 1) {
                System.out.println("set方法" + method2.getName());
            }
        }
        // ----------------------------------------------------------------------

        // 类名
        System.out.println(cls.getName());
        System.out.println(cls.getSimpleName());
        // 修饰符
        int modifiers = cls.getModifiers();
        System.out.println(modifiers);
        System.out.println(Modifier.isPublic(1));
        // 包信息
        Package package1 = cls.getPackage();
        System.out.println(package1.getName());

        // 父类
        Class superCls = cls.getSuperclass();
        System.out.println(superCls.getName());

        // 实现接口
        Class[] interfaces = cls.getInterfaces();
        System.out.println(interfaces.length);

        // -------------------------------------------------

        // 构造器
        // 返回的Constructor数组包含每一个声明为公有的（Public）构造方法。
        Constructor[] constructors = cls.getConstructors();
        System.out.println(constructors.length);
        // 回的构造方法的方法参数为String类型
        Constructor constructor = cls.getConstructor(new Class[] { String.class });
        // 构造方法参数
        Class[] prameterTypes = constructor.getParameterTypes();
        System.out.println(prameterTypes.length + ":" + prameterTypes[0].getName());
        // 利用Constructor对象实例化一个类
        User uer = (User) constructor.newInstance("hello");
        System.out.println(uer.getName() + "-----------------");

        // 注解
        // 类注解 Annotation annotation = cls.getAnnotation(MyAnnotation.class);
        Annotation[] annotations = cls.getAnnotations();
        for (Annotation annotation : annotations) {
            if (annotation instanceof MyAnnotation) {
                MyAnnotation myAnnotation = (MyAnnotation) annotation;
                System.out.println("name:" + myAnnotation.name());
                System.out.println("value:" + myAnnotation.value());
            }
        }
        // 方法注解
        Annotation mAnnotation = method.getAnnotation(MyAnnotation.class);
        if (mAnnotation instanceof MyAnnotation) {
            MyAnnotation myAnnotation = (MyAnnotation) mAnnotation;
            System.out.println("name:" + myAnnotation.name());
            System.out.println("value:" + myAnnotation.value());
        }
        // 参数注解 未实现...................
        // 变量注解 未实现....................
        System.out.println(annotations[0].annotationType());

        User user = (User) cls.newInstance();
        user.setId(0);
        System.out.println(user.getId());

        // -----------------------------------------------------------------

        // 变量
        // 获取Field对象 指定类中声明为公有的(public)的所有变量集合
        Field[] fields = cls.getFields();
        for (int i = 0; i < fields.length; i++) {
            System.out.println("----------------------");
            System.out.println(fields[i].getName());
        }
        // 如果你知道你要访问的变量名称
        Field field = cls.getField("sex");
        // 变量类型
        Object fieldType = field.getType();
        System.out.println(fieldType);
        // 获取或设置（get/set）变量值
        Object value = field.get(user);
        field.set(user, 2);
        System.out.println(user.getSex() + " " + user.getId());

        // ---------------------------------------------------------------

        // 私有变量和私有方法(ps:在通常的观点中从对象的外部访问私有变量以及方法是不允许的，但是Java反射机制可以做到这一点,这个功能只有在代码运行在单机Java应用(standalone Java
        // application)中才会有效,就像你做单元测试或者一些常规的应用程序一样)
        // 访问私有变量
        Field name = cls.getDeclaredField("name");
        name.setAccessible(true);
        System.out.println(name.get(uer));
        // 访问私有方法
        Method privateMethod = cls.getDeclaredMethod("getHelloString", null);
        privateMethod.setAccessible(true);
        System.out.println(privateMethod.invoke(uer, null));

        // 泛型 未实现......................

        // 数组
        // 创建数组
        int[] intArray = (int[]) Array.newInstance(int.class, 3);
        // 访问数组
        Array.set(intArray, 0, 123);
        Array.set(intArray, 1, 456);
        Array.set(intArray, 2, 789);
        System.out.println("intArray[0] = " + Array.get(intArray, 0));
        // 获取数组的成员类型
        String[] strings = new String[3];
        Class stringArrayClass = strings.getClass();
        Class stringArrayComponentType = stringArrayClass.getComponentType();
        System.out.println(stringArrayComponentType);

        // 动态代理
        /**
         * 你可以通过使用Proxy.newProxyInstance()方法创建动态代理。newProxyInstance()方法有三个参数：
        1、类加载器（ClassLoader）用来加载动态代理类。
        2、一个要实现的接口的数组。
        3、一个InvocationHandler把所有方法的调用都转到代理上。
         */
        MyInterface myInterface = new MyInterfaceImpl();
        InvocationHandler handler = new MyInvocationHandler(myInterface);
        MyInterface proxy = (MyInterface) Proxy.newProxyInstance(myInterface.getClass().getClassLoader(),
                new Class[] { MyInterface.class }, handler);
        proxy.print();
        System.out.println("--------------------");

        // 类加载 未完成.........................................
        /**
         * 类加载器加载类的顺序如下：
        1、检查这个类是否已经被加载。
        2、如果没有被加载，则首先调用父加载器加载。
        3、如果父加载器不能加载这个类，则尝试加载这个类。
         */
        //动态类加载
        ClassLoader classLoader = Reflect1.class.getClassLoader();
        Class class1 = classLoader.loadClass("com.reflect.demo.User");
        System.out.println(class1.getName());
        System.out.println(  UUID.randomUUID().toString());
      
    }

    // 取普通对象以及原生对象的Class对象：
    public Class getClass(String className) throws ClassNotFoundException {
        if ("int".equals(className))
            return int.class;
        if ("long".equals(className))
            return long.class;
        return Class.forName(className);
    }

}

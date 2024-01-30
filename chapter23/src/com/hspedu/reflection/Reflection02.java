package com.hspedu.reflection;

import com.hspedu.Cat;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Properties;

/**
 * @author Solider
 * @version 1.0
 * 测试反射调用的性能，以及调优方案
 */
public class Reflection02 {
    public static void main(String[] args) throws IOException, ClassNotFoundException, InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchMethodException {
        long methodTime = method();
        long reflectTime = reflect();
        System.out.println("methodTime = " + methodTime);
        System.out.println("reflectTime = " + reflectTime);
    }

    // 普通方法，创建对象，调用hi方法
    public static long method() {
        long startTime = System.currentTimeMillis();
        Cat cat = new Cat();
        for (int i = 0; i < 2e5; i++) {
            cat.hi();
        }
        long endTime = System.currentTimeMillis();
        return endTime - startTime;
    }

    // 反射方法，调用hi方法
    public static long reflect() throws IOException, ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        long startTime = System.currentTimeMillis();
        // 创建Class类对象，通过反射，获取hi方法的对象
        Class<?> aClass = Class.forName("com.hspedu.Cat");
        Object o = aClass.newInstance();
        Method method = aClass.getMethod("hi");
        // 反射调优-关闭访问安全检查
        method.setAccessible(true);
        for (int i = 0; i < 2e5; i++) {
            method.invoke(o);
        }
        long endTime = System.currentTimeMillis();
        return endTime - startTime;
    }
}

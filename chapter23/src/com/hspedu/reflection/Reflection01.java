package com.hspedu.reflection;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Properties;

/**
 * @author Solider
 * @version 1.0
 *
 */
@SuppressWarnings({"all"})
public class Reflection01 {
    public static void main(String[] args) throws InvocationTargetException, IllegalAccessException, NoSuchMethodException, InstantiationException, ClassNotFoundException, IOException, NoSuchFieldException {
        // 1. 通过，properties对象实例，获取配置文件的路径
        Properties properties = new Properties();
        // 读取配置文件的地址
        properties.load(new FileInputStream("src\\re.properties"));
        // 读取配置文件中的classfullpath，类的全路径
        String classfullpath = properties.getProperty("classfullpath");
        // 读取配置文件中的规定需要调用的方法
        String methodName = properties.getProperty("method");
        System.out.println(classfullpath + "\n" + methodName);
        // 2. 通过Class类中的forName()方法，去获取配置文件的路径
        Class<?> aClass = Class.forName(classfullpath);
        // 根据反射的对象实例aClass，实例对象
        Object o = aClass.newInstance();
        System.out.println(o.getClass());
        Method method = aClass.getMethod(methodName);
        method.invoke(o);
        // 使用反射，获取对象的字段
        // 通过getXXX方法，不能获取私有字段
        Field age = aClass.getField("age");
        System.out.println(age.get(o));

        // 通过反射，获取构造器
        // getConstructor()方法内，传入构造器的参数，若为空，则调用无参构造器
        Constructor<?> constructor = aClass.getConstructor();
        System.out.println(constructor);
        // 有形参的构造器
        Constructor<?> constructor1 = aClass.getConstructor(String.class);
        System.out.println(constructor1);
        // 两个形参的构造器
        Constructor<?> constructor2 = aClass.getConstructor(String.class, int.class);
        System.out.println(constructor2);
    }
}

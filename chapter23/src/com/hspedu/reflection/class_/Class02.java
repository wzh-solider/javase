package com.hspedu.reflection.class_;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author Solider
 * @version 1.0
 * 演示Class类的常用方法
 */
public class Class02 {
    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException, NoSuchFieldException {
        // 通过Class类中的静态方法，获取到指定类名的Class对象
        Class<?> aClass = Class.forName("com.hspedu.Car");
        System.out.println(aClass.getPackage().getName()); // 获取到Class类对象对应实体的包名
        System.out.println(aClass.getClass()); // 获取到aClass的Class对象
        // 调用缺省构造器，返回类的实例
        Object o = aClass.newInstance();

        // 返回该Class类对象所表示的实体(类名、接口、数组类、基本类型...)
        System.out.println(aClass.getName());

        // 返回Class类对象的接口Class[]对象
        Class<?>[] interfaces = aClass.getInterfaces();
        System.out.println(interfaces.length);

        // 返回该Class的类加载器
        ClassLoader classLoader = aClass.getClassLoader();
        System.out.println(classLoader.getName());

        // 返回该Class类所表示实体超类的Class对象
        Class<?> superclass = aClass.getSuperclass();
        System.out.println(superclass.getName());

        // 返回该Class类的实体构造器对象
        Constructor<?>[] constructors = aClass.getConstructors();
        System.out.println(constructors.length);

        // 返回该Class类的实体指定属性的对象
        Field color = aClass.getField("color");
        System.out.println(color.get(o));
        color.set(o, "奔驰");
        System.out.println(color.get(o));
        // 返回该Class类的实体属性对象数组
        Field[] fields = aClass.getDeclaredFields();
        System.out.println(fields.length);

        // 返回该Class类的实体非私有方法对象
        Method didi = aClass.getMethod("didi");
        didi.invoke(o);
    }
}

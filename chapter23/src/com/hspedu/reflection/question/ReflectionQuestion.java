package com.hspedu.reflection.question;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Properties;

/**
 * @author Solider
 * @version 1.0
 */
public class ReflectionQuestion {
    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, IOException, NoSuchMethodException, InvocationTargetException {
        // 通过反射机制，读取配置文件，创建对象
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
        // 3. 通过反射中的getMethod中的方法，将从配置文件中读取到的methodName，实例化为一个对象
        Method method = aClass.getMethod(methodName);
        // 4. 最后通过 方法名.invoke(对象)，来获取到对应的方法
        method.invoke(o);
    }
}

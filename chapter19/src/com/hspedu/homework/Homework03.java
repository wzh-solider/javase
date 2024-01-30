package com.hspedu.homework;

import org.testng.annotations.Test;

import java.io.*;
import java.util.Properties;

/**
 * @author Solider
 * @version 1.0
 */
public class Homework03 {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        // 调用方法
        createProperty();

        // 声明Properties对象，用于获取配置文件中的内容
        Properties properties = new Properties();
        properties.load(new FileReader("src\\dog.properties"));
        String name = properties.getProperty("name");
        String propertyAge = properties.getProperty("age");
        Integer age = Integer.valueOf(propertyAge);
        String color = properties.getProperty("color");
        // 初始化Dog对象
        Dog dog = new Dog(name, age, color);
        System.out.println(dog);

        // 声明一个对象流，用来序列化对象
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("D:\\dog.dat"));
        objectOutputStream.writeObject(dog);
        objectOutputStream.close();

        // 声明一个对象流，用来读取"Dog.dat"序列化文件
        ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("D:\\dog.dat"));
        System.out.println(objectInputStream.readObject());
        objectInputStream.close();
    }

    // 声明一个方法，用来创建一个配置文件
    @Test
    public static void createProperty() throws IOException {
        // 创建一个 Properties 对象
        Properties properties = new Properties();
        properties.setProperty("name", "tom");
        properties.setProperty("age", "5");
        properties.setProperty("color", "red");
        // 使用Sort
        properties.store(new FileWriter("src\\dog.properties"), null);
    }
}



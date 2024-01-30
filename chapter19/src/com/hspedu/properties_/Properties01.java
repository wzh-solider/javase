package com.hspedu.properties_;

import java.io.*;
import java.util.Properties;

/**
 * @author Solider
 * @version 1.0
 * 使用Properties中的方法，来对配置文件进行修改
 */
public class Properties01 {
    public static void main(String[] args) throws IOException {
        // 声明一个Properties对象
        Properties properties = new Properties();
        // 使用类中的方法，修改配置文件中的数据

        // setProperty()方法，设置键值对到Properties对象中，如果不存在直接创建，否则进行覆盖值
        properties.setProperty("id", "2021106");
        properties.setProperty("name", "韩顺平");
        // store()方法，用来将设置的键值对，保存到指定文件中
        // 在store()方法中，可以传入Writer 和 OutputStream类型的方法, 同时会传入一个comments配置文件的注释
        // 传入Writer类型，保存中文时会乱码
        // 传入OutputStream类型，会将中文保存为unicode编码格式
        properties.store(new FileOutputStream("src\\mySql02.properties"), null);
        properties.list(System.out);
    }
}

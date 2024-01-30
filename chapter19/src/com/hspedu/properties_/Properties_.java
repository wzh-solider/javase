package com.hspedu.properties_;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Properties;

/**
 * @author Solider
 * @version 1.0
 */
public class Properties_ {
    public static void main(String[] args) throws IOException {
        // 创建一个Properties对象
        Properties properties = new Properties();
        // 将指定文件路径加载到Properties对象中
        properties.load(new FileReader("src\\mySql.properties"));
        // 通过Properties类中的方法，来读取配置文件的信息

        // list()方法，将配置文件的数据显示到对应的位置
        PrintWriter printWriter = new PrintWriter(new FileWriter("D:\\f1.txt"));
        properties.list(printWriter);
        properties.list(System.out);// 指定为标准输出，默认输出位置为 显示器

        // getProperty()方法，根据键，获取到对应的值， 返回字符串类型
        System.out.println(properties.getProperty("id"));

        // 关闭打印流，否则不会显示到指定文件中
        printWriter.close();
    }
}

package com.hspedu.IO.OutputStream_;

import com.hspedu.IO.OutputStream_.Dog;

import java.io.*;

/**
 * @author Solider
 * @version 1.0
 * 使用ObjectOutputStream来进行序列化操作
 */
public class FileObjectOutputStream {
    public static void main(String[] args) throws IOException {
        String filepath = "D:\\data.dat";
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(filepath));
        objectOutputStream.writeInt(100); // int -> Integer(实现了Serializable)
        objectOutputStream.writeChar('a'); // char -> Character(实现了Serializable)
        objectOutputStream.writeDouble(1.2); // double -> Double(实现了Serializable)
        objectOutputStream.writeBoolean(true); // boolean -> Boolean(实现了Serializable)
        objectOutputStream.writeUTF("韩顺平教育"); // String(实现了Serializable)

        objectOutputStream.writeObject(new Dog("小黄", 12, "黄色", "中国"));
    }
}

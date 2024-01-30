package com.hspedu.IO.OutputStream_;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @author Solider
 * @version 1.0
 */
public class FileOutputStream_ {
    public static void main(String[] args) {

    }

    @Test
    public void fileWrite01() {
        // 创建文件对象
        File file = new File("D://a.txt");
        // 创建 FileOutputStream 流对象，用于进行文件内容的写入
        // 如果在写入时，此文件不存在，就新建该文件
        FileOutputStream fileOutputStream = null;
        char ch = 'A';
        String str = " 此时可以写入多个字节";
        String str1 = "javaSE";
        try {
            fileOutputStream = new FileOutputStream(file);
            // 当使用write(int b)方法时，每次调用只能写入一个字节
            fileOutputStream.write(ch);
            // 但是FileOutputStream同时又重写了 write(byte[] b), 一次调用可以存入多个字节
            fileOutputStream.write(str.getBytes());
            // 而且又重写出了write(byte[] b, int off, int len), 从偏移量为 off的位置读取长度为len的字节
            fileOutputStream.write(str1.getBytes(), 2, 4);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                fileOutputStream.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

    }
}

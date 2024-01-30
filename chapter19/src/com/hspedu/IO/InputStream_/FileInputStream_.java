package com.hspedu.IO.InputStream_;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * @author Solider
 * @version 1.0
 */
public class FileInputStream_ {
    public static void main(String[] args) {

    }

    /*
    读取文件的内容
     */
    @Test
    public void fileRead01() {
        // 创建FileInputStream流对象，用于读取 "D:\\hello.txt" 文件
        String pathname = "D:\\hello.txt";
        int readDate = 0;
        File file = new File(pathname);
        FileInputStream fileInputStream = null;
        try {
            fileInputStream = new FileInputStream(file);
            // 使用read()方法获取文件的字节
            // 1. read()方法每次只能读取一个字节
            // 2. 当文件读取到最后的时候，返回 -1
            while((readDate = fileInputStream.read()) != -1) {
                System.out.print((char)readDate);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                // 关闭文件流，释放资源
                // 并捕获处理异常
                fileInputStream.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    @Test
    public void fileRead02() {
        // 创建FileInputStream流对象，用于读取 "D:\\hello.txt" 文件
        String pathname = "D:\\hello.txt";
        int readLen = 0;
        byte[] buf = new byte[7];
        File file = new File(pathname);
        FileInputStream fileInputStream = null;
        try {
            fileInputStream = new FileInputStream(file);
            // 使用read(byte[] b)来进行读取数据
            // 此方法返回数组的长度
            // 但当文件没有可用字节读取，即已经达到文件末尾，则返回 -1
            while((readLen = fileInputStream.read(buf)) != -1) {
                System.out.print(new String(buf, 0, readLen));
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                // 关闭文件流，释放资源
                // 并捕获处理异常
                fileInputStream.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}

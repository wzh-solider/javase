package com.hspedu.homework;

import org.testng.annotations.Test;

import java.io.*;

/**
 * @author Solider
 * @version 1.0
 * 使用 BufferedReader 读取一个文本文件，为每行加上行号
 * 并连同内容一并输出到屏幕上
 */
public class Homework02 {
    public static void main(String[] args) throws IOException {
        // 调用方法，创建文件
        createFile();

        // 创建一个文件对象
        String filepath = "D:\\homework02.txt";
        File file = new File(filepath);

        // 创建一个字符处理流BufferedReader, 用来读取指定文件的内容
        BufferedReader br = new BufferedReader(new FileReader(file));
        String line = "";
        int row = 0;
        while((line = br.readLine()) != null) {
            BufferedWriter bw = new BufferedWriter(new FileWriter(file));
            bw.write(line + (++row));
            System.out.println(line + row);
        }
    }

    // 声明一个方法，用来创建一个文本文件，并添加内容
    @Test
    public static void createFile() throws IOException {
        // 声明变量，确定文件对象的访问路径
        String filepath = "D:\\homework02.txt";
        File file = new File(filepath);
        // 声明一个字符串变量，用来规定输入内容
        String content = "韩顺平1";
        // 声明一个字符处理流BufferedWriter
        BufferedWriter bw = new BufferedWriter(new FileWriter(filepath));
        bw.write(content);
        bw.newLine();
        content = "韩顺平2";
        bw.write(content);
        bw.newLine();
        content = "韩顺平3";
        bw.write(content);
        bw.close();
    }
}

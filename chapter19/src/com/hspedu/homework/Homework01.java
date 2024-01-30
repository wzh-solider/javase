package com.hspedu.homework;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * @author Solider
 * @version 1.0
 *  1. 判断D盘下是否有文件夹 mytemp, 如果没有创建
 *  2. 在D:\\mytemp目录下，创建文件hello.txt
 *  3. 如果hello.txt已经存在，提示该文件已经存在，无序重复创建
 *  4. 并在hello.txt文件中，写入“hello, world~”
 */
public class Homework01 {
    public static void main(String[] args) throws IOException {
        // 定义一个文件对象，用于获取指定位置的文件
        String filepath = "D:\\mytemp";
        File file = new File(filepath);
        // 判断此文件目录是否存在
        if (!file.exists()) {
            // 不存在，创建目录
            file.mkdir();
        }
        String helloFilepath = "D:\\mytemp\\hello.txt";
        File helloFile = new File(helloFilepath);
        // 判断hello.txt文件是否存在
        if (helloFile.exists()) {
            // 存在，直接输出“文件已经存在”，并退出程序
            System.out.println("文件已经存在");
            System.exit(0);
        }
        // 不存在，则直接创建
        helloFile.createNewFile();

        // 创建一个字符处理流对象，用来写入内容
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(helloFile));
        String str = "hello, world~";
        bufferedWriter.write(str);
        // 关闭流对象
        bufferedWriter.close();
    }
}

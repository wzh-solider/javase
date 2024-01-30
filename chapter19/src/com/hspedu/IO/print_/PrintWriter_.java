package com.hspedu.IO.print_;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author Solider
 * @version 1.0
 * 使用PrintWriter字符打印流，来打印出相应的字符
 */
public class PrintWriter_ {
    public static void main(String[] args) throws IOException {
        // 创建一个printWriter对象，并传入一个PrintSystem的标准流对象，默认打印到显示器
        PrintWriter printWriter = new PrintWriter(System.out);
        printWriter.print("韩顺平");
        printWriter.close();

        // 同时可以将其打印的位置，传入到指定的位置
        PrintWriter printWriter1 = new PrintWriter(new FileWriter("D:\\f.txt"));
        printWriter1.print("韩顺平。。。");
        printWriter1.close();
    }
}

package com.hspedu.IO.transformation;

import com.hspedu.IO.writer_.BufferedWriter_;

import java.io.*;

/**
 * @author Solider
 * @version 1.0
 * 使用转换流 OutputStreamWriter, 字节流文件转换为字符流文件进行写入
 * 并指定为 gbk / utf-8 的编码格式
 */
public class OutputStreamWriter_ {
    public static void main(String[] args) throws IOException {
        // 定义一条路径，如果存在，转换后直接写入，不存在创建后再写入
        String filepath = "D:\\a.txt";
        // 定义编码格式
        String charSet = "UTF-8";
        // 定义一个字符处理流对象，用来接收转换流对象
        BufferedWriter buf = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(filepath), charSet));
        // 定义出一个字符串变量，将其写入到文件中
        String str = "hsp jack韩顺平和杰克";
        buf.write(str);
        // 关闭最外层流
        buf.close();
    }
}

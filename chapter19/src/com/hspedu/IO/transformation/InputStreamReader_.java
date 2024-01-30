package com.hspedu.IO.transformation;

import java.io.*;
import java.nio.charset.StandardCharsets;

/**
 * @author Solider
 * @version 1.0
 * InputStreamReader ==> 将字节流文件，转为字符流
 * 使用转换流InputStreamReader读取文件时，指定编码格式
 */
public class InputStreamReader_ {
    public static void main(String[] args) throws IOException {
        // 将 D:\\b.txt 文件读取到控制台
        File file = new File("D:\\b.txt");
        // 创建一个转换流，用来读取文件的内容
        InputStreamReader isr = new InputStreamReader(new FileInputStream(file), "gbk");
        // 将文件转成字符流之后，按照处理流来进行读取
        BufferedReader br = new BufferedReader(isr);
        String line;
        while((line = br.readLine()) != null) {
            System.out.println(line);
        }

        if(br != null) {
            br.close();
        }
    }
}

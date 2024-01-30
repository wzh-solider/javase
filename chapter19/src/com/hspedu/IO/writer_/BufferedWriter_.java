package com.hspedu.IO.writer_;

import java.io.*;

/**
 * @author Solider
 * @version 1.0
 * 使用BufferedWriter将字符串写入到文件中
 */
public class BufferedWriter_ {
    public static void main(String[] args) throws IOException {
        // 创建一个文件D:\\copy1.txt
        File file = new File("D:\\copy.txt");
        // 创建一个字符输出处理流，写入文件
        String  str = "hello, 韩顺平教育";
        BufferedWriter bw = new BufferedWriter(new FileWriter(file));
        // 将字符串写入到对应文件中
        bw.write(str);
        // 换行接着进行输入
        str = "hello, java工程师";
        bw.newLine(); // 或者使用 bw.write("\r\n"); 转义换行符进行换行
        bw.write(str);
        bw.close();
    }
}

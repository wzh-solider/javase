package com.hspedu.IO.transformation;

import java.io.*;

/**
 * @author Solider
 * @version 1.0
 * 中文乱码问题，使用转换流进行解决
 */
public class CodeProblem {
    public static void main(String[] args) throws IOException{
        // 将 D:\\b.txt 文件读取到控制台
        File file = new File("D:\\b.txt");
        // 创建一个处理流，用来读取文件的内容
        BufferedReader br = null;
        String line;
        br = new BufferedReader(new FileReader(file));
        while((line = br.readLine()) != null) {
            System.out.println(line);
        }
        br.close();
    }
}

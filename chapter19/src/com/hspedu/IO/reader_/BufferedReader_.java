package com.hspedu.IO.reader_;

import java.io.*;

/**
 * @author Solider
 * @version 1.0
 * 使用字符处理流,来进行对文件的读取操作
 */
public class BufferedReader_ {
    public static void main(String[] args) {
        // 定义一个文件对象，确定指定文件的位置
        File file = new File("D:\\story.txt");
        // 声明一个字符节点输入流，用来读取对应文件的内容
        BufferedReader br = null;
        String line;
        try {
            br = new BufferedReader(new FileReader(file));
            // 调用处理流，使用设计模式包装的方法，按行读取
            // 返回读取的字符串， 如果到达文件末尾，则返回 null;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            // 关闭处理流
            try {
                br.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}

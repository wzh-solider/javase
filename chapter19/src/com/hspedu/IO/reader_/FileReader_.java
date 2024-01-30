package com.hspedu.IO.reader_;

import java.io.*;

/**
 * @author Solider
 * @version 1.0
 */

// 使用FileReader字符流，读取D:\\story.txt文件中的内容
public class FileReader_ {
    public static void main(String[] args) {
        // 声明一个文件对象，用来获取文件的路径
        File file = new File("D:\\story.txt");
        fileWriter();
        // 声明一个文件输出流对象，用来读取文件中的内容
        FileReader fileReader = null;
        // 定义一个char类型的数组，用来存储从文件中读取的字符
        char[] buf = new char[4];
        int readLen = 0;
        try {
            fileReader = new FileReader(file);
            while((readLen = fileReader.read(buf)) != -1) {
                System.out.print(new String(buf, 0, readLen));
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                fileReader.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

    }

    // 规定一个方法，用来创建并向该文件中写入内容
    public static void fileWriter() {
        // 创建一个文件对象
        File file = new File("D:\\story.txt");

        // 判断该文件是否存在，不存在进行创建，存在则直接写入
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        // 定义一个文件输入流对象，用来向文件中写入内容
        FileWriter fileWriter  = null;
        String str = "这是一个文件，里面保存的是字符类型的内容"; // 向文件中写入的内容
        try {
            fileWriter = new FileWriter(file); // 默认覆盖的方式进行存储
            fileWriter.write(str);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            // 关闭流对象
            try {
                // 关闭流对象，相当于 ==> flush() + 关闭
                fileWriter.close();
                // fileWriter.flush();

            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}

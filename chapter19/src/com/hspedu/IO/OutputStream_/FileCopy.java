package com.hspedu.IO.OutputStream_;

import java.io.*;

/**
 * @author Solider
 * @version 1.0
 */
public class FileCopy {
    public static void main(String[] args) {
        // 规定需要进行拷贝的文件 及 拷贝到的路径
        String srcFilepath = "D:\\小米.webp";
        String destFilepath = "D:\\fileCopy\\小米.webp";
        // 定义出文件输入和输出流
        FileInputStream fileInputStream = null;
        FileOutputStream fileOutputStream = null;
        // 定义出文件输入的byte数组进行接收
        int fileLen = 0;
        byte[] buf = new byte[1024];
        try {
            // 将文件输入，输出流进行初始化
            fileInputStream = new FileInputStream(srcFilepath);
            fileOutputStream = new FileOutputStream(destFilepath);
            // 进行文件读取，同时进行写入操作
            while ((fileLen = fileInputStream.read(buf)) != -1) {
                fileOutputStream.write(buf, 0, fileLen);
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            // 关闭文件输入，输出流
            try {
                fileOutputStream.close();
                fileInputStream.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}

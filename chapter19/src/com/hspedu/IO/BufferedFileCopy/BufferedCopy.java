package com.hspedu.IO.BufferedFileCopy;

import java.io.*;

/**
 * @author Solider
 * @version 1.0
 * 使用BufferedInputStream和BufferedOutputStream
 * 可以完成对 二进制文件的拷贝
 */
public class BufferedCopy {
    public static void main(String[] args) {
        // 创建两个文件，用来获取需要进行拷贝的文件和拷贝的位置
        File srcFilePath = new File("D:\\花之舞 - 纯音乐网.mp3");
        File destFilePath = new File("D:\\fileCopy\\花之舞 - 纯音乐网.mp3");
        // 创建字节文件输入输出流
        BufferedInputStream bufferedInputStream = null;
        BufferedOutputStream bufferedOutputStream = null;
        // 定义一个byte[]数组，接收读取的字节
        byte[] buf = new byte[1024];
        // 定义整型，作为循环的开关
        int fileLen = 0;
        try {
            // 初始化文件输入输出流，同时将 输入输出抽象基类的 实现子类传入构造器
            bufferedInputStream = new BufferedInputStream(new FileInputStream(srcFilePath));
            bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(destFilePath));
            while((fileLen = bufferedInputStream.read(buf)) != -1) {
                bufferedOutputStream.write(buf, 0, fileLen);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                // 此时仅需要关闭外层节点流，即可关闭内部的节点流
                if (bufferedOutputStream != null) {
                    bufferedOutputStream.close();
                }
                if (bufferedOutputStream != null) {
                    bufferedOutputStream.close();
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}

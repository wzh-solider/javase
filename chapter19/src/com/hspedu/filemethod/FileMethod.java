package com.hspedu.filemethod;

import org.testng.annotations.Test;

import java.io.File;

/**
 * @author Solider
 * @version 1.0
 */
public class FileMethod {
    public static void main(String[] args) {

    }

    @Test
    public void fileInfo() {
        File file = new File("D:\\news1.txt");
        // 获取文件名称
        System.out.println("文件名称：" + file.getName());
        // 获取文件绝对路径
        System.out.println("文件绝对路径：" + file.getAbsolutePath());
        // 获取文件父级目录
        System.out.println("文件的父级目录：" + file.getParent());
        // 获取文件大小（字节）
        System.out.println("文件大小（字节）：" + file.length());
        // 判断文件是否为目录
        System.out.println("文件是否为目录（文件夹）：" + file.isDirectory());
        // 判断文件是否为是一个文件
        System.out.println("该文件是否为一个文件：" + file.isFile());
        // 判断文件是否存在
        System.out.println("该文件是否存在：" + file.exists());
    }
}

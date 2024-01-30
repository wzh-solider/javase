package com.hspedu.file;

import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;

public class FileCreate {
    public static void main(String[] args) {

    }

    // 使用 new File(String pathname);构造器创建文件对象

    /**
     * pathname 文件的绝对路径
     */
    @Test
    public static void fileCreate01() {
        String filePath = "D:\\news1.txt";
        File file = new File(filePath);
        try {
            file.createNewFile();
            System.out.println("文件创建成功");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    // 使用 new File(File parent, String child);构造器创建文件对象

    /**
     * parent 父级文件目录，绝对路径
     * child 子级文件目录，相对父级的目录
     */
    @Test
    public static void fileCreate02() {
        File parentFile = new File("D:\\createfile\\");
        String fileName = "news2.txt";
        File file = new File(parentFile, fileName);
        try {
            file.createNewFile();
            System.out.println("文件创建成功");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    // 使用 new File(String parent, String child);构造器创建文件对象

    /**
     * parent 父级文件目录，绝对路径
     * child 子级文件目录，相对父级的目录
     */
    @Test
    public static void fileCreate03() {
        String parentFile = "D:\\createfile\\";
        String fileName = "news3.txt";
        File file = new File(parentFile, fileName);
        try {
            file.createNewFile();
            System.out.println("文件创建成功");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
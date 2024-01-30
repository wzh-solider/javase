package com.hspedu.filemethod;

import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;

/**
 * @author Solider
 * @version 1.0
 */
public class Directory_ {
    public static void main(String[] args) {

    }

    // 判断 "D:\\news1.txt" 文件 是否存在，如果存在则删除
    @Test
    public void method01() {
        String filePath = "D:\\news1.txt";
        File file = new File(filePath);
        if (file.exists()) {
            System.out.println("该文件存在");
            if (file.delete()) {
                System.out.println(file.getName() + "删除成功。。。");
            }
        } else {
            System.out.println("该文件不存在，删除失败。。。");
        }
    }

    // 判断 "D:\\Dir" 目录 是否存在，如果存在则删除
    @Test
    public void method02() {
        String directoryPath = "D:\\Dir";
        File file = new File(directoryPath);
        if (file.exists()) {
            System.out.println("该目录存在");
            if (file.delete()) {
                System.out.println(file.getName() + "删除成功。。。");
            }
        } else {
            System.out.println("该目录不存在，删除失败。。。");
        }
    }

    // 创建一级目录
    @Test
    public void method03() {
        String path_mkdir = "D:\\path_mkdir";
        File file = new File(path_mkdir);
        if(!file.exists()) {
            if (file.mkdir()) {
                System.out.println("一级目录创建成功");
            } else {
                System.out.println("一级目录创建失败");
            }
        }
    }

    // 创建多级目录
    @Test
    public void method04() {
        String path_mkdirs = "D:\\path_mkdirs\\a\\b\\c";
        File file = new File(path_mkdirs);
        if(!file.exists()) {
            if (file.mkdirs()) {
                System.out.println("多级目录创建成功");
            } else {
                System.out.println("多级目录创建失败");
            }
        }
    }
}

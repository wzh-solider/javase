package com.hspedu.stringbuffer_;

import com.hspedu.string_.StringExercise;

import java.util.Scanner;

public class StringBufferExercise02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("请输入商品名：");
        StringBuffer sb1 = new StringBuffer(scanner.next());
        System.out.print("请输入商品价格：");
        StringBuffer sb2 = new StringBuffer(scanner.next());
        /*第一种方法：使用while语句
        int index = sb2.indexOf(".");
        sb2.insert(index - 3, ",");
        index = sb2.indexOf(",");
        while(index > 3) {
            sb2.insert(index - 3, ",");
            index = sb2.indexOf(",");
        }*/

        // 第二种方法：使用for循环
        for(int index = sb2.lastIndexOf(".") - 3; index > 0; index -= 3) {
            sb2.insert(index, ",");
        }
        System.out.println("商品名\t商品价格");
        System.out.println(sb1 + "\t" + sb2);
    }
}

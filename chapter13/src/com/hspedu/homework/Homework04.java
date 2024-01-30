package com.hspedu.homework;

import java.util.Scanner;

public class Homework04 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入一个字符串");
        String str = scanner.nextLine();
        int isUpper = 0, isLower = 0, isNum = 0;
        char[] chars = str.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (Character.isUpperCase(chars[i])) {
                isUpper++;
            } else if (Character.isLowerCase(chars[i])) {
                isLower++;
            } else if (Character.isDigit(chars[i])) {
                isNum++;
            }
        }
        System.out.println("有" + isUpper + "个大写字母");
        System.out.println("有" + isLower + "个小写字母");
        System.out.println("有" + isNum + "个数字");
    }
}
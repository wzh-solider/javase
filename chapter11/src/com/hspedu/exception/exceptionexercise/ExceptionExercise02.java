package com.hspedu.exception.exceptionexercise;

import java.util.Scanner;

public class ExceptionExercise02 {
    public static void main(String[] args) {
        Scanner myScanner = new Scanner(System.in);
        while(true) {
            try {
                Integer.parseInt(myScanner.next());
                break;
            } catch (NumberFormatException e) {
                System.out.println("格式错误请重新输入...");
            }
        }
        System.out.println("输入正确...");
    }
}

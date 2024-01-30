package com.hspedu.exception;

public class Homework01 {
    public static void main(String[] args) {
        try {
            int n1 = Integer.parseInt(args[0]);
            int n2 = Integer.parseInt(args[1]);
            Homework01.cal(n1, n2);
        } catch (NumberFormatException e) {
            System.out.println("数字格式不正确");
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("缺少命令参数");
        }

    }

    public static void cal(int n1, int n2) {
        try {
            double result = n1 / n2;
            System.out.println(result);
        } catch (ArithmeticException e) {
            System.out.println("被除数不能为0");
        }
    }
}

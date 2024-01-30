package com.hspedu.recursion;

public class T1 {
    public static void main(String[] args) {
        T01 t01 = new T01();
        System.out.println(t01.fibonacci(7));
    }
}

class T01 {
    public int fibonacci(int n) {
        if (n >= 1) {
            if (n == 1 || n == 2) {
                return 1;
            } else {
                return fibonacci(n - 1) + fibonacci(n - 2);
            }
        } else {
            System.out.println("数应该>1");
            return -1;
        }
    }
}
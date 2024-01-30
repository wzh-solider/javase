package com.hspedu.fibonacci;

public class Fibonacci {
    public static void main(String[] args) {
        int n1 = 1, n2 = 1;
            for (int i = 1; i <= 15; i++) {
                System.out.print(n1 + " " + n2 + " ");
                n1 = n1 + n2;
                n2 = n1 + n2;
                if (i % 2 == 0) System.out.println();
            }
    }
}

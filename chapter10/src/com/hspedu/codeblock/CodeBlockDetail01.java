package com.hspedu.codeblock;

public class CodeBlockDetail01 {
    public static void main(String[] args) {
        // A a = new A();
        System.out.println(A.n1);
    }
}

class A {


    static {
        System.out.println("静态代码块被调用...");
    }

    static int n1 = getN1();

    public static int getN1() {
        System.out.println("静态方法被调用...");
        return 100;
    }
}

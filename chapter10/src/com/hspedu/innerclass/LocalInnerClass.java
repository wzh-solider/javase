package com.hspedu.innerclass;

public class LocalInnerClass {
    public static void main(String[] args) {
        new Outer03().say();
    }
}

class Outer03 { // 外部类
    private int n1 = 10;
    private static String name = "张三";
    public void say() {
        int n3 = 30;
        class LocalInner01 { // 相当于局部变量
            int n2 = 40;
            int n1 = 20;
            public void show() {
                System.out.println(n2);
                System.out.println("n1 = " + Outer03.this.n1);
            }
        }
        LocalInner01 localInner01 = new LocalInner01();
        localInner01.show();
    }
}

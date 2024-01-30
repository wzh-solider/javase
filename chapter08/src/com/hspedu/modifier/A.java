package com.hspedu.modifier;

public class A {
    public int n1 = 100; // public 公开权限，允许公共访问
    protected int n2 = 200; // protected 保护权限，允许本类，本包的类，子类访问
    int n3 = 300; // default 默认权限， 允许本类，本包的类访问
    private int n4 = 400; // private 私有权限， 只允许本类访问
    public void m1() {
        // 本类中可以访问四种修饰符
        System.out.println("n1 = " + n1);
        System.out.println("n2 = " + n2);
        System.out.println("n3 = " + n3);
        System.out.println("n4 = " + n4);
    }
}

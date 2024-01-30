package com.hspedu.modifier;

public class Test {
    public static void main(String[] args) {
        A a = new A();
        a.m1();
        System.out.println(a.n1);
        System.out.println(a.n2);
        System.out.println(a.n3);
        // System.out.println(a.n4); n4为私有属性，只允许本类访问
        B b = new B();
        b.look();
    }
}

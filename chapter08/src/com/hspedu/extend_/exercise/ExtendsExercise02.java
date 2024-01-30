package com.hspedu.extend_.exercise;

public class ExtendsExercise02 {
    public static void main(String[] args) {
        System.out.println(new C01());
    }
}

class A01 {
    A01() {
        System.out.println("我是A01无参构造器");
    }
}

class B01 extends A01 {
    B01() {
        System.out.println("我是B01无参构造器");
    }
    B01(String name) {
        System.out.println(name + "我是B01有参构造器");
    }
}

class C01 extends B01 {
    C01() {
        this("hello");
        System.out.println("我是C01无参构造器");
    }
    C01(String name) {
        super("hahaha");
        System.out.println("我是C01有参构造器");
    }
}

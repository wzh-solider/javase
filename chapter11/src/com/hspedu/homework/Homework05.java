package com.hspedu.homework;

public class Homework05 {
    public static void main(String[] args) {
        new A("王五").f1();
    }
}

class A {
    private String name;

    public A(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public void f1() {
        class B {
            private final String name = "李四";
            public void show() {
                System.out.println(name + A.this.name);
            }
        }
        new B().show();
    }
}

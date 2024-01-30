package com.hspedu.innerclass;

public class AnonymousInnerClass {
    public static void main(String[] args) {
        OuterClass outerClass = new OuterClass();
        outerClass.method();
    }
}

class OuterClass {
    public void method(){
        Dog dog = new Dog();
        dog.cry();
    }
}

interface AA {
    void cry();
}

class Dog implements AA {
    public void cry() {
        System.out.println("小狗叫...");
    }
}
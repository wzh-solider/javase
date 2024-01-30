package com.hspedu.ploy_;

public class Animal {
    public void show() {
        System.out.println("动物总类");
    }
}

class Dog extends Animal {
    public void show() {
        System.out.println("小狗汪汪叫~~~");
    }
}

class Cat extends Animal {
    public void show() {
        System.out.println("小猫喵喵叫~~~");
    }
}
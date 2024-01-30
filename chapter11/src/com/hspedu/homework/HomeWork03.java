package com.hspedu.homework;

public class HomeWork03 {
    public static void main(String[] args) {
        new Cat().shout();
        new Dog().shout();
    }
}

abstract class Animal {
    abstract void shout();
}

class Cat extends Animal {
    @Override
    public void shout() {
        System.out.println("猫会喵喵叫");
    }
}
class Dog extends Animal {
    @Override
    public void shout() {
        System.out.println("狗会汪汪叫");
    }
}

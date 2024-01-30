package com.hspedu.object_;

public class Finalize {
    public static void main(String[] args) {
        Car baoma = new Car("宝马");
        baoma = null;
        System.gc();
        System.out.println("程序退出...");
    }
}

class Car {
    private String name;

    public Car(String name) {
        this.name = name;
    }
    public void finalize() throws Throwable{
        System.out.println("这个对象已被清理");
    }
}

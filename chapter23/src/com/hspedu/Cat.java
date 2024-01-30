package com.hspedu;

/**
 * @author Solider
 * @version 1.0
 */
public class Cat {
    private String name = "招财猫";
    public int age = 10;

    public Cat() {}

    public Cat(String name) {
        this.name = name;
    }

    public Cat(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void hi() {
        // System.out.println(name + ", say hi~");
    }
}

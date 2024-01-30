package com.hspedu.IO.OutputStream_;

import java.io.Serializable;

public class Dog implements Serializable {
    private String name;
    private int age;
    private static String color;
    private transient String country;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Dog{" +
                "name='" + name + '\'' +
                ", age=" + age + '\'' +
                ", color = " + color + '\'' +
                ", country='" + country + '\'' +
                '}';
    }

    public Dog(String name, int age, String color, String country) {
        this.name = name;
        this.age = age;
        Dog.color = color;
        this.country = country;
    }
}
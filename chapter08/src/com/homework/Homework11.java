package com.homework;

public class Homework11 {
    public static void main(String[] args) {
        Person1 p1 = new Student();
        p1.run();
        p1.eat();
        Student s = (Student)p1;
        s.run();
        s.study();
    }
}

class Person1 {
    public void run() {
        System.out.println("person run");
    }
    public void eat() {
        System.out.println("person eat");
    }
}

class Student extends Person1 {
    @Override
    public void run() {
        System.out.println("student run");
    }

    public void study() {
        System.out.println("student study..");
    }
}

package com.hspedu.override.exercise;

public class OverrideExercise {
    public static void main(String[] args) {
        Person person = new Person("小明", 18);
        Student student = new Student("小明", 18, "10010", 45.2);
        System.out.println("person = " + person.say());
        System.out.println("student = " + student.say());
    }
}

class Person {
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }
    public String say() {
        return "我的名字是：" + this.name + "\n" + "我今年" + this.age + "岁";
    }
}

class Student extends Person {
    private String id;
    private double score;

    public Student(String name, int age, String id, double score) {
        super(name, age);
        this.id = id;
        this.score = score;
    }
    public String say() {
        return super.say() + "\nid = " + this.id + "\nscore = " + this.score;
    }
}

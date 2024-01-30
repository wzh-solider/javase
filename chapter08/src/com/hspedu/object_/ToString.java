package com.hspedu.object_;

public class ToString {
    public static void main(String[] args) {
        Monster monster = new Monster("jack", 18, 2000);
        System.out.println(monster.toString());
        System.out.println(monster);
    }
}

class Monster {
    private String name;
    private int age;
    private int salary;
    public Monster(String name, int age, int salary) {
        this.name = name;
        this.age = age;
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Monster{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", salary=" + salary +
                '}';
    }
}
package com.hspedu.encap;

public class Encapsulation01 {
    public static void main(String[] args) {
        Person person = new Person();
        person.setName("J");
        person.setAge(100);
        person.setSalary(1000);
        person.setJob("华为");
        System.out.println(person.show());
    }
}

class Person {
    public String name;
    private int age;
    private double salary;
    private String job;

    public void setAge(int age) {
        if (age >= 1 && age <= 120) {
            this.age = age;
        } else this.age = 50;
    }

    public int getAge() {
        return this.age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name.length() >= 2 && name.length() <= 5) {
            this.name = name;
        } else {
            this.name = "无名氏";
        }
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public String show() {
        return "name = " + this.name + "age = " + this.age + "Salary = " + this.salary +
                "job = " + this.job;
    }
}


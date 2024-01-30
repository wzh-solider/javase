package com.homework;

public class Homework01 {
    public static void main(String[] args) {
        Person[] person = new Person[3];
        person[0] = new Person("jack", 18, "JavaEE工程师");
        person[1] = new Person("mark", 12, "教师");
        person[2] = new Person("somNum", 11, "JavaScript前端工程师");
        Homework01 h = new Homework01();
        h.sort(person);
        for (int i = 0; i < person.length; i++) {
            System.out.println(person[i].toString());
        }
        h.sortName(person);
        for (Person i : person) {
            System.out.println(i.toString());
        }

    }

    public static void sort(Person[] person) {
        for (int i = 1; i < person.length; i++) {
            for (int j = 0; j < person.length - i; j++) {
                if (person[j].getAge() > person[j + 1].getAge()) {
                    Person temp = person[j];
                    person[j] = person[j + 1];
                    person[j + 1] = temp;
                }
            }
        }
    }
    public static void sortName(Person[] person) {
        for (int i = 0; i < person.length - 1; i++) {
            for (int j = 0; j < person.length - i - 1; j++) {
                if (person[j].getName().length() > person[j + 1].getName().length()) {
                    Person temp = person[j];
                    person[j] = person[j + 1];
                    person[j + 1] = temp;
                }
            }
        }
    }
}

class Person {
    private String name;
    private int age;
    private String job;

    public Person(String name, int age, String job) {
        this.name = name;
        this.age = age;
        this.job = job;
    }

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

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", job='" + job + '\'' +
                '}';
    }
}

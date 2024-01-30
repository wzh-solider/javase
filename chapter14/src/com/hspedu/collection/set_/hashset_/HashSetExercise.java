package com.hspedu.collection.set_.hashset_;

import java.util.HashSet;
import java.util.Objects;

@SuppressWarnings({"all"})
public class HashSetExercise {
    public static void main(String[] args) {
        HashSet set = new HashSet();
        Employee employee = new Employee("Jack", 17);
        Employee employee1 = new Employee("Mark", 18);
        Employee employee2 = new Employee("Jack", 17);
        set.add(employee);
        set.add(employee1);
        set.add(employee2);
        System.out.println(set);
    }
}

class Employee {
    private String name;
    private Integer age;

    public Employee(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return Objects.equals(name, employee.name) && Objects.equals(age, employee.age);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }

    @Override
    public String toString() {
        return "[name: " + name + ", age: " + age + "]";
    }
}

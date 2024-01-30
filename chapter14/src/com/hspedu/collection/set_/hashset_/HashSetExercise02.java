package com.hspedu.collection.set_.hashset_;
import java.util.Date;
import java.util.HashSet;
import java.util.Objects;

@SuppressWarnings({"all"})
public class HashSetExercise02 {
    public static void main(String[] args) {
        Employee01 employee01 = new Employee01("jack", 23.2, 2003, 12, 2);
        Employee01 employee02 = new Employee01("mark", 34.2, 2003, 2, 5);
        Employee01 employee03 = new Employee01("jack", 23.2, 2003, 12, 2);
        HashSet set = new HashSet();
        set.add(employee01);
        set.add(employee02);
        set.add(employee03);
        System.out.println(set);
    }
}

class Employee01 {
    private String name;
    private double sal;
    private MyDate birthday;

    public Employee01(String name, double sal, long year, long month, long day) {
        this.name = name;
        this.sal = sal;
        this.birthday = new MyDate(year, month, day);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee01 that = (Employee01) o;
        return Objects.equals(name, that.name) && Objects.equals(birthday, that.birthday);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, birthday);
    }

    @Override
    public String toString() {
        return "Employee01{" +
                "name='" + name + '\'' +
                ", sal=" + sal +
                ", birthday=" + birthday +
                '}';
    }
}

class MyDate {
    private long year;
    private long month;
    private long day;


    public MyDate(long year, long month, long day) {
        this.year = year;
        this.month = month;
        this.day = day;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MyDate myDate = (MyDate) o;
        return year == myDate.year && month == myDate.month && day == myDate.day;
    }

    @Override
    public int hashCode() {
        return Objects.hash(year, month, day);
    }

    @Override
    public String toString() {
        return year + "-" + month + "-" + day;
    }
}

package com.hspedu.generic.exercise;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;

public class GenericExercise01 {
    public static void main(String[] args) {
        ArrayList<Employee> list = new ArrayList<>();
        list.add(new Employee("hsp", 2000, new MyDate(2000, 5, 10)));
        list.add(new Employee("mark", 4000, new MyDate(2003, 3, 20)));
        list.add(new Employee("hsp", 12000, new MyDate(1998, 10, 6)));
        list.sort(new Comparator<Employee>() {
            @Override
            public int compare(Employee o1, Employee o2) {
                if (!(o1 instanceof Employee && o2 instanceof Employee)) {
                    return 0;
                }
                int i = o1.getName().compareTo(o2.getName());
                if (i != 0) {
                    return i;
                }
                return o1.getBirthday().compareTo(o2.getBirthday());
            }
        });
        Iterator<Employee> it = list.iterator();
        for (Employee employee : list) {
            System.out.println(employee);
        }
    }
}

class Employee {
    private String name;
    private int sal;
    private MyDate birthday;

    public Employee(String name, int sal, MyDate birthday) {
        this.name = name;
        this.sal = sal;
        this.birthday = birthday;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSal() {
        return sal;
    }

    public void setSal(int sal) {
        this.sal = sal;
    }

    public MyDate getBirthday() {
        return birthday;
    }

    public void setBirthday(MyDate birthday) {
        this.birthday = birthday;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", sal=" + sal +
                ", birthday='" + birthday + '\'' +
                '}';
    }
}

class MyDate implements Comparable<MyDate> {
    private int year;
    private int month;
    private int day;

    public MyDate(int year, int month, int day) {
        this.year = year;
        this.month = month;
        this.day = day;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    @Override
    public String toString() {
        return "MyDate{" +
                "year=" + year +
                ", month=" + month +
                ", day=" + day +
                '}';
    }

    @Override
    public int compareTo(MyDate o) {
        return year != o.getYear() ? year - o.getYear() :
                (month != o.getMonth() ? month - o.getMonth() :
                        (day != o.getDay() ? day - o.getDay() : 0));
    }
}

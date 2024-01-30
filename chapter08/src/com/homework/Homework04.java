package com.homework;


public class Homework04 {
    public static void main(String[] args) {
        Employe employee1 = new Ordinary("jack", 1000, 30);
        Employe employee2 = new Manger("mark", 2000, 30);
        System.out.println(employee1.showSalary());
        System.out.println(employee2.showSalary());
    }
}

class Employe {
    private String name;
    private int salary;
    private int day;

    public Employe(String name, int salary, int day) {
        this.name = name;
        this.salary = salary;
        this.day = day;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public String showSalary() {
        return name + "员工工资：" + salary;
    }
}

class Manger extends Employe {
    private double grade = 1.2;
    public Manger(String name, int salary, int day) {
        super(name, salary, day);
    }
    @Override
    public String showSalary() {
        return super.getName() + "经理工资：" + ( 1000 + getSalary() * super.getDay() * this.grade);
    }
}

class Ordinary extends Employe {
    public Ordinary(String name, int salary, int day) {
        super(name, salary, day);
    }

    @Override
    public String showSalary() {
        return super.getName() + "普通员工工资：" + (super.getSalary() * super.getDay());
    }
}

package com.homework;

public class Homework05 {
    public static void main(String[] args) {
        Employee e1 = new worker("Worker", 1000, 365);
        Employee e2 = new Farmer("Farmer", 1000, 365);
        Employee e3 = new Waiter("Waiter", 1000, 365);
        Employee e4 = new Teache_("Teacher", 1000, 365, 10);
        Employee e5 = new Scientist("Scientist", 1000, 365);
        System.out.println(e1.showSalary());
        System.out.println(e2.showSalary());
        System.out.println(e3.showSalary());
        System.out.println(e4.showSalary());
        System.out.println(e5.showSalary());
    }
}

class Employee {
    private String name;
    private int salary;

    private int day;

    public Employee(String name, int salary, int day) {
        this.name = name;
        this.salary = salary;
        this.day = day;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public String getName() {
        return name;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String showSalary() {
        return name + "工资：" + salary * day;
    }
}

class worker extends Employee {
    public worker(String name, int salary, int day) {
        super(name, salary, day);
    }

    @Override
    public String showSalary() {
        return super.showSalary();
    }
}

class Farmer extends Employee {
    public Farmer(String name, int salary, int day) {
        super(name, salary, day);
    }

    @Override
    public String showSalary() {
        return super.showSalary();
    }
}

class Waiter extends Employee {
    public Waiter(String name, int salary, int day) {
        super(name, salary, day);
    }

    @Override
    public String showSalary() {
        return super.showSalary();
    }
}

class Teache_ extends Employee {
    private double coure;
    public Teache_(String name, int salary, int day, double coure) {
        super(name, salary, day);
        this.coure = coure;
    }

    public double getCoure() {
        return coure;
    }

    public void setCoure(double coure) {
        this.coure = coure;
    }

    @Override
    public String showSalary() {
        return super.getName() + "教师工资：" + ((super.getSalary() + coure)* super.getDay()) ;
    }
}

class Scientist extends Employee {
    private int year = 5000;
    public Scientist(String name, int salary, int day) {
        super(name, salary, day);
    }

    public Scientist(String name, int salary, int day, int year) {
        super(name, salary, day);
        this.year = year;
    }

    @Override
    public String showSalary() {
        return super.getName() + "科学家工资：" + (super.getSalary() * super.getDay() + year);
    }
}

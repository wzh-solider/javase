package com.hspedu.abstract_;

import java.util.concurrent.CancellationException;

public class AbstractExercise01 {
    public static void main(String[] args) {
        CommonEmployee commonEmployee = new CommonEmployee("小强", "10002", 9090);
        Manager manager = new Manager("小明", "2000", 100000);
        commonEmployee.work();
        manager.work();
    }
}

abstract class Employee {
    private String name;
    private String id;
    private double salary;

    public Employee(String name, String id, double salary) {
        this.name = name;
        this.id = id;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public abstract void work();
}

class CommonEmployee extends Employee {
    public CommonEmployee(String name, String id, double salary) {
        super(name, id, salary);
    }

    public void work() {
        System.out.println("普通员工: " + super.getName() + "正在工作中...");
    }
}

class Manager extends Employee {
    public Manager(String name, String id, double salary) {
        super(name, id, salary);
    }

    @Override
    public void work() {
        System.out.println("经理：" + super.getName() + "正在工作中...");
    }
}

package com.hspedu.homework;

import java.awt.*;
import java.util.Scanner;

public class Homework06 {
    public static void main(String[] args) {
        Person person = new Person("唐僧", Tools.horse());
        person.travle(false);
    }
}

interface Vehicles {
    void work();
}

class Horse implements Vehicles {
    public void work() {
        System.out.println("horse");
    }
}

class Boat implements Vehicles {
    public void work() {
        System.out.println("boat");
    }
}
class Tools {
    public static Vehicles horse() {
        return new Horse();
    }

    public static Vehicles boat() {
        return new Boat();
    }
}

class Person {
    String name;
    Vehicles vehicles;

    public Person(String name, Vehicles vehicles) {
        this.name = name;
        this.vehicles = vehicles;
    }

    public void travle(boolean isRiver) {
        if (isRiver) {
            this.vehicles = Tools.boat();
        } else {
            this.vehicles = Tools.horse();
        }
        System.out.print(this.name + "乘坐的是：");
        this.vehicles.work();
    }
}
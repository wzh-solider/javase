package com.hspedu.generic.ordinaryquestion;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class OrdinaryQuestion {
    @SuppressWarnings({"all"})
    public static void main(String[] args) {
        List list = new ArrayList();
        list.add(new Dog("小白", 12));
        list.add(new Dog("小红", 16));
        list.add(new Dog("小蓝", 18));
        Iterator it = list.iterator();
        while(it.hasNext()) {
            Object next = it.next();
            System.out.println(((Dog)next).getName());
        }
    }
}

class Dog {
    String name;
    int age;

    public Dog(String name, int age) {
        this.name = name;
        this.age = age;
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
}

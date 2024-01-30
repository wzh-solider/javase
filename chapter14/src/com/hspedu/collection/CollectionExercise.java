package com.hspedu.collection;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class CollectionExercise {
    @SuppressWarnings({"all"})
    public static void main(String[] args) {
        Collection col = new ArrayList();
        col.add(new Dog("小白", 10));
        col.add(new Dog("小红", 12));
        col.add(new Dog("小黑", 18));
        Iterator it = col.iterator();
        while(it.hasNext()) {
            System.out.println(it.next());
        }

        for (Object o : col) {
            System.out.println(o);
        }
    }
}

class Dog {
    private String name;
    private int age;

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

    @Override
    public String toString() {
        return "Dog{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
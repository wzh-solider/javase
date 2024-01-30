package com.hspedu.collection.set_.hashset_;

import java.util.HashSet;

public class HashSet01 {
    @SuppressWarnings({"all"})
    public static void main(String[] args) {
        HashSet set = new HashSet();
        System.out.println(set.add("john"));
        System.out.println(set.add("lucy"));
        System.out.println(set.add("john"));
        System.out.println(set.add("jack"));
        System.out.println(set.add("Rose"));
        set.remove("john");
        System.out.println("set = " + set);
        HashSet set1 = new HashSet();
        set1.add("lucy");
        set1.add("lucy");
        set1.add(new Dog("tom"));
        set1.add(new Dog("tom"));
        System.out.println("set1 = " + set1);
    }
}

class Dog {
    private String name;

    public Dog(String name) {
        this.name = name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name;
    }
}

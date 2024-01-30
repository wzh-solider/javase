package com.hspedu.collection.set_.hashset_.linkedhashset_;

import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

@SuppressWarnings({"all"})
public class LinkedHashSetSource {
    public static void main(String[] args) {
        Set set = new LinkedHashSet();
        set.add(new String("int"));
        set.add(123);
        set.add(123);
        set.add(new Dog("Jack"));
    }
}

class Dog {
    String name;

    public Dog(String name) {
        this.name = name;
    }
}

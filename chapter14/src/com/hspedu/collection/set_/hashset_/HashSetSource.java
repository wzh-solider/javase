package com.hspedu.collection.set_.hashset_;

import java.util.HashSet;
import java.util.Objects;

public class HashSetSource {
    @SuppressWarnings({"all"})
    public static void main(String[] args) {
        HashSet set = new HashSet();
        set.add("java");
        set.add("php");
        set.add("java");
        System.out.println(set);
        set = new HashSet();
        for(int i = 0; i < 16; i++) {
            set.add(new A(i));
        }
    }
}

class A {
    int num;
    public A (int num) {
        this.num = num;
    }


    @Override
    public int hashCode() {
        return 100;
    }
}
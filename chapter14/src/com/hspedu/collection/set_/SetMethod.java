package com.hspedu.collection.set_;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class SetMethod {
    @SuppressWarnings({"all"})
    public static void main(String[] args) {
        // set ==> Set接口对象（Set接口实现类的对象）
        Set set = new HashSet();
        set.add("Jack");
        set.add("John");
        set.add("Mark");
        set.add("Mary");
        set.add("Mark");
        set.add("hsp");
        set.add("hsp");
        set.add(null);
        set.add(null);
        set.remove("hsp");
        System.out.println(set);
        /*Iterator it = set.iterator();
        while (it.hasNext()) {
            Object next =  it.next();
            System.out.println(next);
        }*/
    }
}

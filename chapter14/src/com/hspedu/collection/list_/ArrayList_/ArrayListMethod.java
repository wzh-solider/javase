package com.hspedu.collection.list_.ArrayList_;

import java.util.ArrayList;
import java.util.Collection;

public class ArrayListMethod {
    @SuppressWarnings({"all"})
    public static void main(String[] args) {
        Collection col = new ArrayList();
        col.add("小龙女");
        col.add(100);
        col.add(true);
        col.add(new Integer(100));
        System.out.println(col.size());

        col.remove("小龙女");
        System.out.println(col.size());
        boolean contains = col.contains(100);
        System.out.println(contains);
        System.out.println(col.isEmpty());
        col.clear();
        System.out.println(col.size());
        System.out.println(col.isEmpty());
        Collection c = new ArrayList();
        c.add("AA");
        c.add("BB");
        c.add("CC");
        col.addAll(c);
        System.out.println(col.size());
        Collection c2 = new ArrayList();
        c2.add("AA");
        c2.add("BB~");
        boolean containsAll = col.containsAll(c2);
        System.out.println(containsAll);
        col.removeAll(c2);
        System.out.println(col.size());
    }
}

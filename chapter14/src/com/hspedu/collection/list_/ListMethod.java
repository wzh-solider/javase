package com.hspedu.collection.list_;

import java.util.ArrayList;
import java.util.List;

public class ListMethod {
    @SuppressWarnings({"all"})
    public static void main(String[] args) {
        List list = new ArrayList();
        list.add(0, 1);
        list.add(1, 2);
        list.add(2, 3);
        list.add(2, 4);
        System.out.println("list = " + list);
        List list1 = new ArrayList();
        list1.add(10);
        list1.add(11);
        System.out.println("list1 = " + list1);
        list.addAll(2, list1);
        System.out.println("list = " + list);
        System.out.println(list.get(2));
        System.out.println(list.set(2, 100));
        System.out.println(list);
        System.out.println(list.subList(2, 5));
    }
}

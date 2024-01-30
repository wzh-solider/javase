package com.hspedu.collection.list_;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ListExercise {
    @SuppressWarnings({"all"})
    public static void main(String[] args) {
        List list = new ArrayList();
        list.add("hello1");
        list.add("hello2");
        list.add("hello3");
        list.add("hello4");
        list.add("hello5");
        list.add("hello6");
        list.add("hello7");
        list.add("hello8");
        list.add("hello9");
        list.add("hello10");
        list.add(2, "韩顺平教育");
        System.out.println("list = " + list);
        System.out.println(list.get(4));
        list.remove(5);
        System.out.println("list = " + list);
        list.set(6, "jack");
        System.out.println("list = " + list);
        Iterator it = list.iterator();
        while (it.hasNext()) {
            System.out.print(it.next() + ", ");
        }
        System.out.println();
        for (Object o : list) {
            System.out.print(o);
        }
    }
}

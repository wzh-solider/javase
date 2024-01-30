package com.hspedu.collection.list_.ArrayList_;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

public class ArrayListSource {
    @SuppressWarnings({"all"})
    public static void main(String[] args) {
        ArrayList list = new ArrayList();

        //ArrayList list = new ArrayList(10);
        for (int i = 1; i <= 10; i++) {
            list.add(i);
        }
        for (int i = 11; i <= 15; i++) {
            list.add(i);
        }

        list.add(100);
        list.add(200);
        list.add(null);
        for (Object o : list) {
            System.out.println(o);
        }
    }
}

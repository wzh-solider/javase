package com.hspedu.collection;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class CollectionIterator {
    @SuppressWarnings({"all"})
    public static void main(String[] args) {
        Collection col = new ArrayList();
        col.add("one");
        col.add("two");
        col.add("three");
        Iterator it = col.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }
        while (it.hasNext()) {
            Object next = it.next();

        }



    }


}

package com.hspedu.collection.list_.vector_;

import java.util.Iterator;
import java.util.Vector;
public class Vector_ {
    @SuppressWarnings({"all"})
    public static void main(String[] args) {
        Vector vector = new Vector();
        for (int i = 1; i <= 10; i++) {
            vector.add(i);
        }
        for (int i = 0; i < 10; i++) {
            vector.add(i);
        }
        Iterator it = vector.iterator();
        for (Object o : vector) {
            System.out.println(o);

        }
    }

}

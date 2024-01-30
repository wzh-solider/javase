package com.hspedu.object_;

public class Equals01 {
    public static void main(String[] args) {
        "jain".equals("wang");
        Integer integer1 = new Integer(1000);
        Integer integer2 = new Integer(1000);
        System.out.println(integer1 == integer2);
        System.out.println(integer1.equals(integer2));
    }
}
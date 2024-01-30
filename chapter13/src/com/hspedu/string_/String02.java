package com.hspedu.string_;

public class String02 {
    public static void main(String[] args) {
        String str = new String("hsp");
        System.out.println(str + str.hashCode());
        str = "jack";
        System.out.println(str + str.hashCode());
    }
}

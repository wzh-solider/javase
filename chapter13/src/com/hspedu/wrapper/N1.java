package com.hspedu.wrapper;

public class N1 {
    public static void main(String[] args) {
        int n1 = 1;
        double n2 = 2.0d;
        //int n3 = n1 > n2 ? n1 : n2;
        Integer i = 100;
        String str1 = String.valueOf(i);
        String str2 = i.toString();
        String str3 = i + "";
        Integer j = new Integer(str1);
        Integer j1 = Integer.valueOf(str2);
    }
}

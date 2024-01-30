package com.hspedu.string_.stringmethod;

public class StringMethod {
    public static void main(String[] args) {
        String str = "JackAndRose";
        System.out.println(str.equals("TomAndJury"));
        System.out.println(str.equalsIgnoreCase("jackandrose"));
        System.out.println(str.length());
        System.out.println(str.indexOf('R'));
        System.out.println(str.lastIndexOf('e'));
        System.out.println(str.substring(5));
        System.out.println(str.substring(0, 5));
        String str1 = " and ";
        System.out.println(str1.trim());
        char ch = str.charAt(0);
        System.out.println(ch);
        System.out.println(str.toLowerCase());
        System.out.println(str.toUpperCase());
        System.out.println(str.concat("mary"));
        System.out.println(str.replace("Jack", "mary"));
        String str2 = "宝马 | 奔驰 | 保时捷";
        String[] arr = str2.split("\\|");
        for (String i : arr) {
            System.out.print(i);
        }
        System.out.println();
        System.out.println(str.compareTo("j"));
        String a = "abdc";
        String b = "abcdef";
        int i = a.compareTo(b);
        System.out.println(i);
    }
}

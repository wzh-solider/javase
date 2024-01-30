package com.hspedu.stringbuffer_;

public class StringBuffer01 {
    public static void main(String[] args) {
        StringBuffer sb = new StringBuffer();
        sb.append("hello world");
        System.out.println(sb);
        sb.delete(0, 2);
        System.out.println(sb);
        sb.replace(0, 3, "hsp");
        System.out.println(sb);
        System.out.println(sb.indexOf("world"));
        sb.insert(0, 'c');
        System.out.println(sb);

    }
}

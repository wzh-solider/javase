package com.hspedu.homework;

public class HomeWork01 {
    public static void main(String[] args) {
        String str = "abcdefg";
        try {
            str = reverse(str, 1, 7);
            System.out.println(str);
        } catch (Exception e) {
            str = reverse(str, 1, 5);
            System.out.println(str);
        }
    }

    public static String reverse(String str, int start, int end) {
        if (!(str != null && start < end && end < str.length() && start > 0)) {
            throw new RuntimeException("参数错误！！！");
        }
        char[] ch = str.toCharArray();
        while(start < end) {
            char c = ch[start];
            ch[start] = ch[end];
            ch[end] = c;
            start++;
            end--;
        }
        return new String(ch);
    }
}

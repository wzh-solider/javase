package com.hspedu.exception;
public class Exception_ {
    public static void main(String[] args) {
        try {
            int i = 1, j = 0;
            int s = i / j;
            System.out.println(s);
            int[] arr = null;
            System.out.println(arr[1]);
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}

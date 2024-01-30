package com.hspedu.debug_;

import java.util.Arrays;

public class Debug02 {
    public static void main(String[] args) {
        int[] arr = {-1, 2, 33, 21, 10};
        Arrays.sort(arr);
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }
}

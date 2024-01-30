package com.hspedu.pkg;

import java.util.Arrays;

public class Import01 {
    public static void main(String[] args) {
        System.out.println(Math.PI);
        int[] arr = {-1, 2, 10, 4, 3};
        // Arrays.sort(arr); // 系统提供的Array包，中sort类将数组进行升序排列
        A01 a01 = new A01();
        a01.sort(arr);
        for (int j : arr) {
            System.out.print(j + " ");
        }
    }
}



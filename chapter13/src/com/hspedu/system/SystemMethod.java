package com.hspedu.system;

import java.util.Arrays;

public class SystemMethod {
    public static void main(String[] args) {
        String str = "";
        int a = 1, b = 2;
        if (a > b) System.exit(0);
        System.out.println("程序未终止");
        int[] arr = {1, 2, 3};
        int[] arrnew = new int[arr.length];
        System.arraycopy(arr, 0, arrnew, 0, 3);
        System.out.println(Arrays.toString(arrnew));
        long start = System.currentTimeMillis();
        for (int i = 0; i < 80000; i++) {
            str += i;
        }
        long end = System.currentTimeMillis();
        System.out.println(end - start);

    }
}

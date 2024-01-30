package com.hspedu.arrays;

import java.util.Arrays;
import java.util.List;

public class ArraysMethod {
    public static void main(String[] args) {
        Integer[] arr = {1, 2, 3};
        Integer[] newArray = Arrays.copyOf(arr, arr.length);
        System.out.println(Arrays.toString(newArray));
        Arrays.fill(arr, 4);
        System.out.println(Arrays.toString(arr));
        System.out.println(Arrays.equals(arr, newArray));
        List<Integer> asList = Arrays.asList(arr);
        System.out.println(asList);
    }
}

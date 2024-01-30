package com.hspedu.exception.exceptionexercise;

public class ExceptionExercise01 {
    public static void method() {
        try {
            int i = 1 / 0;
            System.out.println(i);
            int[] arr = {1, 2, 3};
            System.out.println(arr[3]);
        } catch (ArithmeticException e) {
            System.out.println(3);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println(4);
        } finally {
            System.out.println(5);
        }
    }
    public static void main(String[] args) {
        method();
    }
}

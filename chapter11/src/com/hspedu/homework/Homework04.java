package com.hspedu.homework;

public class Homework04 {
    public static void main(String[] args) {
        double n3 = new CellPhone().testWork(new Calculator() {
            @Override
            public double work(double n1, double n2) {
                return n1 + n2;
            }
        }, 2, 3);
        System.out.println(n3);
    }
}

interface Calculator {
    double work(double n1, double n2);
}

class CellPhone {
    public double testWork(Calculator calculator, double n1, double n2) {
        double result = calculator.work(n1, n2);
        return result;
    }
}

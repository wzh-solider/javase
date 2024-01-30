package com.hspedu.math_;

import java.util.Random;

public class MathMethod {
    public static void main(String[] args) {
        int a = 2;
        int b = 3;
        System.out.println("-2的绝对值：" + Math.abs(-2));
        System.out.println("2 ^ 3 = " + Math.pow(2, 3));
        System.out.println("3.22向上取整：" + Math.ceil(3.22));
        System.out.println("3.22向下取整：" + Math.floor(3.22));
        System.out.println("3.22四舍五入：" + Math.round(3.22));
        System.out.println("4的开方：" + Math.sqrt(4));
        System.out.println("随机数：" + Math.random());
        System.out.println("2, 3的最大值：" + Math.max(a, b));
        System.out.println("2, 3的最小值：" + Math.min(a, b));
        Random ra = new Random();
        int i = ra.nextInt(100);
        System.out.println(i);
        System.out.println("a ~ b 之间的整数：" + (int)(a + Math.random() * (b - a + 1)));
    }
}

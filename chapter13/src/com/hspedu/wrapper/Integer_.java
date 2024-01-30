package com.hspedu.wrapper;

public class Integer_ {
    public static void main(String[] args) {
        int n1 = 100;
        // 手动装箱
        Integer integer = new Integer(n1);
        // 或
        Integer integer1 = Integer.valueOf(n1);
        // 手动拆箱
        int value1 = integer1.intValue();

        int n2 = 200;
        // 自动装箱
        Integer integer2 = n2; // 底层会直接调用 Integer.valueOf(n2);
        // 自动拆箱
        int value2 = integer2; // 同样的，底层直接调用了 integer2.intValue();
    }
}

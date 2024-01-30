package com.hspedu.ploy_.detail;

public class DemoPropertyOverrideDetail {
    public static void main(String[] args) {
        Base base = new Sub();
        System.out.println(base.count);
        Sub sub = (Sub)base;
        System.out.println(sub.count);
    }
}

class Base {
    int count = 10;
}

class Sub extends Base {
    int count = 20;
}

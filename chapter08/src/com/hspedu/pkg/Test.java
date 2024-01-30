package com.hspedu.pkg;

import com.hspedu.modifier.A;

public class Test {
    public static void main(String[] args) {
        A a = new A();
        System.out.println(a.n1);
        /*
        System.out.println(a.n2); A类中，n2为protected权限，不同包不能访问
        System.out.println(a.n3); n3为default权限
        System.out.println(a.n4); n4为private权限
        */
    }
}

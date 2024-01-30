package com.hspedu.object_;

public class HashCode_ {
    public static void main(String[] args) {
        AA aa1 = new AA();
        AA aa2 = new AA();
        System.out.println(aa1.hashCode());
        System.out.println(aa2.hashCode());
        aa1 = aa2;
        System.out.println(aa1.hashCode());
    }
}

class AA {

}
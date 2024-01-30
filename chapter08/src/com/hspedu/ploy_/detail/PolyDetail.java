package com.hspedu.ploy_.detail;

public class PolyDetail {
    public static void main(String[] args) {
        BB bb = new BB();
        System.out.println(bb instanceof AA);
        System.out.println(bb instanceof BB);
        AA aa = new BB();
        System.out.println(aa instanceof BB);
    }
}

class AA {}
class BB extends AA {}
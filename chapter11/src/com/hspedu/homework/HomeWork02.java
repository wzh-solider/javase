package com.hspedu.homework;

public class HomeWork02 {
    public static void main(String[] args) {
        System.out.println(Frock.getNextNum());
        System.out.println(Frock.getNextNum());
        Frock frock1 = new Frock();
        Frock frock2 = new Frock();
        Frock frock3 = new Frock();
        if (frock2.getSerialNumber() - frock1.getSerialNumber() == 100 &&
            frock3.getSerialNumber() - frock2.getSerialNumber() == 100) {
            System.out.println(frock1.getSerialNumber());
            System.out.println(frock2.getSerialNumber());
            System.out.println(frock3.getSerialNumber());
        } else {
            System.out.println("没有按照100递增");
        }
    }
}

class Frock {
    private static int currentNum = 100000;
    private int serialNumber;

    public Frock() {
        this.serialNumber = getNextNum();
    }

    public static int getNextNum() {
        return currentNum += 100;
    }

    public int getSerialNumber() {
        return serialNumber;
    }

}



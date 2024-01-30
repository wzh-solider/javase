package com.hspedu.runnable;

/**
 * @author Solider
 * @version 1.0
 */
public class Runnable_ {
    public static void main(String[] args) {
        Cat cat = new Cat();
        Thread thread = new Thread(cat);
        thread.start();
    }
}

class Cat implements Runnable {
    @Override
    public void run() {
        System.out.println("开启Cat线程...");
    }
}
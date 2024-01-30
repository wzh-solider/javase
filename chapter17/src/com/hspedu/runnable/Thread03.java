package com.hspedu.runnable;

/**
 * @author Solider
 * @version 1.0
 */
public class Thread03 {
    public static void main(String[] args) {
        SayHello sayHello = new SayHello();
        SayHi sayHi = new SayHi();
        Thread thread = new Thread(sayHello);
        thread.start();
        thread = new Thread(sayHi);
        thread.start();
    }
}

class SayHello implements Runnable {
    int count;
    @Override
    public void run() {
        do {
            System.out.println("hello, world" + (++count));
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        } while (count < 10);
    }
}

class SayHi implements Runnable {
    int count;
    @Override
    public void run() {
        do {
            System.out.println("hi" + (++count));
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        } while (count < 5);
    }
}
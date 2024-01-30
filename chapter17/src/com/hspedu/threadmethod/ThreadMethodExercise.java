package com.hspedu.threadmethod;

/**
 * @author Solider
 * @version 1.0
 */
public class ThreadMethodExercise{
    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 10; i++) {
            Thread.sleep(1000);
            System.out.println("hi" + (i + 1));
            if (i + 1 == 5) {
                SayHello sayHello = new SayHello();
                Thread thread = new Thread(sayHello);
                thread.start();
                thread.join();
            }
        }
    }
}

class SayHello implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("hello" + (i + 1));
        }
    }
}
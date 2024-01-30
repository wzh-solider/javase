package com.hspedu.threaduse;

/**
 * @author Solider
 * @version 1.0
 * 通过继承Thread类，创建线程
 */
public class Thread01 {
    public static void main(String[] args) {
        Cat cat = new Cat();
        // 开启一个线程
        cat.start(); // 最终会调用cat中的run方法
        /* 但如果仅仅使用cat.run();那么程序则会直接调用run()方法，而不会开启子线程
        相当于这条语句还是在main线程中 */
        System.out.println("主线程继续执行" + Thread.currentThread().getName());
        for (int i = 0; i < 60; i++) {
            System.out.println("主线程i = " + i);
        }
    }
}

class Cat extends Thread {
    int count;

    @Override
    public void run() {
        while (true) {
            // 使小猫叫
            System.out.println("喵喵喵~~" + ++count);
            // 每叫一次，就睡眠1秒
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            if (count == 80) break;
        }
    }
}

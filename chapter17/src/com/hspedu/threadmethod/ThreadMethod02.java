package com.hspedu.threadmethod;

/**
 * @author Solider
 * @version 1.0
 * 线程的礼让 和 插队
 */
public class ThreadMethod02 {
    public static void main(String[] args) throws InterruptedException {
        Thread01 thread01 = new Thread01();
        thread01.start();
        for (int i = 1; i <= 20; i++) {
            Thread.sleep(1000);
            System.out.println("main线程 正在吃包子..." + i);
            if (i == 5) {
                // 当main线程吃完5个之后（不管包子够不够吃），让thread01线程先吃完20个包子，然后自己再吃
                // thread01.join();
                // 当资源紧张时（包子不够吃），main线程进行礼让，thread01线程先吃；
                // 当资源充足时（包子够吃），则不进行礼让
                Thread.yield();
            }
        }
    }
}

class Thread01 extends Thread {
    @Override
    public void run() {
        for (int i = 1; i <= 20; i++) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("线程1 正在吃包子..." + i);
        }
    }
}


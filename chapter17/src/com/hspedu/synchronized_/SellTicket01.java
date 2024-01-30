package com.hspedu.synchronized_;

/**
 * @author Solider
 * @version 1.0
 * 售票窗口 (1)
 */
/*
    这里，因为在开启多线程时，是new出来不同的对象
    new SellTicket01().start();
    new SellTicket01().start();
    new SellTicket01().start();
    所以锁的对象不同，也就锁不住这里的线程
    因此在运行时，同样会出现超卖的现象
 */
public class SellTicket01 extends Thread {
    static int ticketNum = 100;
    private boolean loop = true;
    public synchronized void sell() {
        if (ticketNum <= 0) {
            System.out.println("售票结束...");
            loop = false;
            return;
        }

        try {
            Thread.sleep(50);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("窗口 " + Thread.currentThread().getName() + "售出" +
                "还剩 " + (--ticketNum) + " 张票");
    }
    @Override
    public void run() {
        while (loop) {
            sell();
        }
    }
}

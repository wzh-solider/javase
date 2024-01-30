package com.hspedu.synchronized_;

/**
 * @author Solider
 * @version 1.0
 */
public class SellTicket02 implements Runnable {
    private int ticketNum = 100;
    private boolean loop = true;

    @Override
    public void run() {
        while (loop) {
            synchronized (this) { // 同步代码块
                if (ticketNum <= 0) {
                    System.out.println("售票结束");
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
        }
    }
}

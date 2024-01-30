package com.hspedu.ticket;

/**
 * @author Solider
 * @version 1.0
 * 售票窗口 (1)
 */
public class SellTicket01 extends Thread {
    static int ticketNum = 100;

    @Override
    public void run() {
        while (true) {
            if (ticketNum <= 0) {
                System.out.println("售票结束...");
                break;
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

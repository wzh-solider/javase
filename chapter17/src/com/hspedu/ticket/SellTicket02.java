package com.hspedu.ticket;

/**
 * @author Solider
 * @version 1.0
 */
public class SellTicket02 implements Runnable {
    private int ticketNum = 100;
    @Override
    public void run() {
            while (true) {
                if (ticketNum <= 0) {
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

package com.hspedu.synchronized_;

/**
 * @author Solider
 * @version 1.0
 */
public class SellTicket {
    public static void main(String[] args) {
//        SellTicket01 sellTicket01 = new SellTicket01();
//        SellTicket01 sellTicket011 = new SellTicket01();
//        SellTicket01 sellTicket012 = new SellTicket01();
//        sellTicket01.start();
//        sellTicket011.start();
//        sellTicket012.start();
        SellTicket02 sellTicket02 = new SellTicket02();
        new Thread(sellTicket02).start();
        new Thread(sellTicket02).start();
        new Thread(sellTicket02).start();
//        SellTicket03 sellTicket03 = new SellTicket03();
//        new Thread(sellTicket03).start();
//        new Thread(sellTicket03).start();
//        new Thread(sellTicket03).start();
    }
}

class SellTicket03 implements Runnable {
    private int ticketNum = 100;
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

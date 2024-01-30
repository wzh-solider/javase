package com.hspedu.homework;

/**
 * @author Solider
 * @version 1.0
 */
public class Homework02 {
    public static void main(String[] args) {
        ToMoney toMoney = new ToMoney();
        new Thread(toMoney).start();
        new Thread(toMoney).start();
    }
}

class ToMoney implements Runnable {
    private int money = 10000;

    @Override
    public void run() {
        while (true) {
            synchronized (this) {
                if (money <= 0) {
                    System.out.println("余额不足，无法取出...");
                    break;
                }
                money -= 1000;
                System.out.println("用户" + Thread.currentThread().getName() + "取出1000" +
                        "还剩" + (money) + "元");
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

        }
    }
}

package com.hspedu.synchronized_;

/**
 * @author Solider
 * @version 1.0
 */
public class DeadLock_ {
    public static void main(String[] args) {
        DeadLockDemo deadLockDemo1 = new DeadLockDemo(true);
        DeadLockDemo deadLockDemo2 = new DeadLockDemo(false);
        deadLockDemo1.setName("线程A");
        deadLockDemo1.start();
        deadLockDemo2.setName("线程B");
        deadLockDemo2.start();
    }
}

class DeadLockDemo extends Thread {
    static Object o1 = new Object(); // 保证多线程，共享同一个对象，使用static
    static Object o2 = new Object();
    boolean flag;

    public DeadLockDemo(boolean flag) {
        this.flag = flag;
    }

    @Override
    public void run() {
        // 1. 当 flag = T; synchronized (o1)会拿到o1锁
        // 2. 当 flag = F; synchronized (o2)会拿到o2锁
        /* 因为两个线程开启。
            在 flag = T;条件内中的 synchronized (o2)拿不到o2锁，导致线程A阻塞在
            System.out.println(Thread.currentThread().getName() + "进入1");
            在 flag = F;条件内中的 synchronized (o1)拿不到o1锁，导致线程B阻塞在
            System.out.println(Thread.currentThread().getName() + "进入3");
        */
        if (flag) {
            synchronized (o1) {
                System.out.println(Thread.currentThread().getName() + "->进入1");
                synchronized (o2) { // 获取对象的监视权
                    System.out.println(Thread.currentThread().getName() + "->进入2");
                }
            }
        } else {
            synchronized (o2) {
                System.out.println(Thread.currentThread().getName() + "->进入3");
                synchronized (o1) { // 获取对象的监视权
                    System.out.println(Thread.currentThread().getName() + "->进入4");
                }
            }
        }
    }
}

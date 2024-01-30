package com.hspedu.exit_;

/**
 * @author Solider
 * @version 1.0
 */
public class ThreadExit {
    public static void main(String[] args) throws InterruptedException {
        Thread01 thread01 = new Thread01();
        long start = System.currentTimeMillis();
        // 开启线程
        thread01.start();
        // 主线程休眠10秒后，关闭线程
        Thread.sleep(10 * 1000);
        long end = System.currentTimeMillis();
        thread01.setLoop(false);
        System.out.println(end - start);
    }
}

class Thread01 extends Thread {
    private int count;
    private boolean loop = true;

    // 创建loop变量，在主线程中控制此线程的开关
    public void setLoop(boolean loop) {
        this.loop = loop;
    }

    @Override
    public void run() {
        while (loop) {
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("线程运行..." + (++count));
        }
    }
}

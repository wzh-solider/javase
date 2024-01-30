package com.hspedu.threadmethod;

/**
 * @author Solider
 * @version 1.0
 */
public class ThreadMethods {
    public static void main(String[] args) throws InterruptedException {
        Eat eat = new Eat();
        // 开启线程
        eat.start();
        for (int i = 0; i < 5; i++) {
            Thread.sleep(1000);
            System.out.println("hi~" + i);
        }
        // 当主线程输出五次"hi~"后，中断eat线程的休眠，但并没有结束eat线程
        eat.interrupt();
    }
}

class Eat extends Thread {
    @Override
    public void run() {
        while (true) {
            for (int i = 0; i < 20; i++) {
                System.out.println("吃了" + i + "个包子");
            }
            // 当吃了20个包子后，休息10秒，继续吃
            try {
                System.out.println(Thread.currentThread().getName() + "~~正在休眠中");
                Thread.sleep(10 * 1000);
            } catch (InterruptedException e) {
                System.out.println(Thread.currentThread().getName() + "~~被interrupt了");
            }
        }
    }
}

package com.hspedu.runnable;

/**
 * @author Solider
 * @version 1.0
 * 模仿一个简单的Thread类，解释Runnable如何进行开启线程
 */
public class Runnable02 {
    public static void main(String[] args) {
        Dog dog = new Dog();
        ThreadProxy threadProxy = new ThreadProxy(dog);
        threadProxy.start();
    }
}

// 简单的线程代理类 ==> 类似于底层Thread的小部分代码
class ThreadProxy implements Runnable {
    private Runnable target = null;

    @Override
    public void run() {
        if (target != null) {
            target.run();
        }
    }

    public ThreadProxy(Runnable target) {
        this.target = target;
    }

    public void start() {
        start0(); // 此方法是真正实现多线程的方法
    }

    public void start0() {
        run();
    }
}

class Animal {

}
class Dog extends Animal implements Runnable {
    @Override
    public void run() {
        System.out.println("Dog线程开启");
    }
}

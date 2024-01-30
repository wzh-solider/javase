package com.hspedu.tankgame04;

import java.util.Vector;

/**
 * @author Solider
 * @version 1.0
 * 敌人的坦克
 */
public class EnemyTank extends Tank implements Runnable {
    // 设置敌方坦克的生命周期
    private boolean loop = true;
    // 设置子弹
    Fire fire = null;
    // 因为子弹可能是多线程，所以使用vector集合，存放坦克的子弹 <==> 坦克弹药库
    Vector<Fire> fires = new Vector<>();

    public boolean isLoop() {
        return loop;
    }

    public void setLoop(boolean loop) {
        this.loop = loop;
    }

    public EnemyTank(int x, int y) {
        super(x, y);
    }

    // 设置线程，实现敌方坦克自由移动
    @Override
    public void run() {
        while (true) {
            switch (getDirection()) {
                case 0 -> {
                    for (int i = 0; i < 30; i++) {
                        MoveUp();
                        // 每行走一个单位，就睡眠50毫秒
                        try {
                            Thread.sleep(50);
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }
                }
                case 1 -> {
                    for (int i = 0; i < 30; i++) {
                        MoveRight();
                        try {
                            Thread.sleep(50);
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }
                }
                case 2 -> {
                    for (int i = 0; i < 30; i++) {
                        MoveDown();
                        try {
                            Thread.sleep(50);
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }
                }
                case 3 -> {
                    for (int i = 0; i < 30; i++) {
                        MoveLeft();
                        try {
                            Thread.sleep(50);
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }
                }
            }

            // 每次移动30个单位后，重新生成随机数，重置方向
            setDirection((int) (Math.random() * 4));
        }
    }
}

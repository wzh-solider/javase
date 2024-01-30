package com.hspedu.tankgame05;

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
            // 判断坦克是否存在，同时控制敌方子弹在场上的存在数量
            if (isLoop() && fires.size() < 2) {
                // 根据坦克的不同朝向，初始化子弹
                switch (getDirection()) {
                    case 0 -> fire = new Fire(getX() + 20, getY(), getDirection());
                    case 1 -> fire = new Fire(getX() + 60, getY() + 20, getDirection());
                    case 2 -> fire = new Fire(getX() + 20, getY() + 60, getDirection());
                    case 3 -> fire = new Fire(getX(), getY() + 20, getDirection());
                }
                // 将该子弹，添加到集合中
                fires.add(fire);
                // 开启子弹线程 <==> 发射
                new Thread(fire).start();
            }
            // 根据坦克朝向，移动方向
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

            // 每次移动30个单位后，生成随机数，重置方向
            setDirection((int) (Math.random() * 4));
        }
    }
}

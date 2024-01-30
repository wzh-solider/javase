package com.hspedu.tankgame06;

import java.security.spec.ECPoint;
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
    // 防止碰撞， 设置碰撞属性
    private boolean collide = false;
    // 在敌方坦克类中，添加一个集合，用来保存敌方坦克
    // 同时指定set方法，对集合进行初始化
    Vector<EnemyTank> enemyTanks = new Vector<>();

    public void setEnemyTanks(Vector<EnemyTank> enemyTanks) {
        this.enemyTanks = enemyTanks;
    }

    // 判断坦克是否发生碰撞
    public boolean isCollide() {
        return collide;
    }

    public boolean collided() {

        switch (this.getDirection()) {
            case 0:
                for (int j = 0; j < enemyTanks.size(); j++) {
                    EnemyTank otherEnemyTank = enemyTanks.get(j);
                    if (enemyTanks.get(j) != this) {
                        if (otherEnemyTank.getDirection() == 0 || otherEnemyTank.getDirection() == 2) {
                            if (this.getX() >= otherEnemyTank.getX()
                                    && this.getX() <= otherEnemyTank.getX() + 40
                                    && this.getY() >= otherEnemyTank.getY()
                                    && this.getY() <= otherEnemyTank.getY() + 60) {
                                return true;
                            }
                            if (this.getX() + 40 >= otherEnemyTank.getX()
                                    && this.getX() + 40 <= otherEnemyTank.getX() + 40
                                    && this.getY() >= otherEnemyTank.getY()
                                    && this.getY() <= otherEnemyTank.getY() + 60) {
                                return true;
                            }
                        }
                        if (otherEnemyTank.getDirection() == 1 || otherEnemyTank.getDirection() == 3) {
                            if (this.getX() > otherEnemyTank.getX()
                                    && this.getX() <= otherEnemyTank.getX() + 60
                                    && this.getY() >= otherEnemyTank.getY()
                                    && this.getY() <= otherEnemyTank.getY() + 40
                            ) {
                                return true;
                            }
                            if (this.getX() + 40 >= otherEnemyTank.getX()
                                    && this.getX() + 40 <= otherEnemyTank.getX() + 60
                                    && this.getY() >= otherEnemyTank.getY()
                                    && this.getY() <= otherEnemyTank.getY() + 40
                            ) {
                                return true;
                            }
                        }
                    }
                }
                break;
            case 1:
                for (int j = 0; j < enemyTanks.size(); j++) {
                    EnemyTank otherEnemyTank = enemyTanks.get(j);
                    if (enemyTanks.get(j) != this) {
                        if (otherEnemyTank.getDirection() == 0 || otherEnemyTank.getDirection() == 2) {
                            if (this.getX() + 60 >= otherEnemyTank.getX()
                                    && this.getX() + 60 <= otherEnemyTank.getX() + 40
                                    && this.getY() >= otherEnemyTank.getY()
                                    && this.getY() <= otherEnemyTank.getY() + 60
                            ) {
                                return true;
                            }
                            if (this.getY() + 40 >= otherEnemyTank.getY()
                                    && this.getY() + 40 <= otherEnemyTank.getY() + 60
                                    && this.getX() + 60 >= otherEnemyTank.getX()
                                    && this.getX() + 60 <= otherEnemyTank.getX() + 40) {
                                return true;
                            }
                        }
                        if (otherEnemyTank.getDirection() == 1 || otherEnemyTank.getDirection() == 3) {
                            if (this.getX() + 60 >= otherEnemyTank.getX()
                                    && this.getX() + 60 <= otherEnemyTank.getX() + 60
                                    && this.getY() >= otherEnemyTank.getY()
                                    && this.getY() <= otherEnemyTank.getY() + 40
                            ) {
                                return true;
                            }
                            if (this.getY() + 40 >= otherEnemyTank.getY()
                                    && this.getY() + 40 <= otherEnemyTank.getY() + 40
                                    && this.getX() + 60 >= otherEnemyTank.getX()
                                    && this.getX() + 60 <= otherEnemyTank.getX() + 60) {
                                return true;
                            }
                        }
                    }
                }
                break;
            case 2:
                for (int j = 0; j < enemyTanks.size(); j++) {
                    EnemyTank otherEnemyTank = enemyTanks.get(j);
                    if (enemyTanks.get(j) != this) {
                        if (otherEnemyTank.getDirection() == 0 || otherEnemyTank.getDirection() == 2) {
                            if (this.getX() >= otherEnemyTank.getX()
                                    && this.getX() <= otherEnemyTank.getX() + 40
                                    && this.getY() + 60 >= otherEnemyTank.getY()
                                    && this.getY() + 60 <= otherEnemyTank.getY() + 60
                            ) {
                                return true;
                            }
                            if (this.getX() + 40 >= otherEnemyTank.getX()
                                    && this.getX() + 40 <= otherEnemyTank.getX() + 40
                                    && this.getY() + 60 >= otherEnemyTank.getY()
                                    && this.getY() + 60 <= otherEnemyTank.getY() + 60) {
                                return true;
                            }
                        }
                        if (otherEnemyTank.getDirection() == 1 || otherEnemyTank.getDirection() == 3) {
                            if (this.getX() >= otherEnemyTank.getX()
                                    && this.getX() <= otherEnemyTank.getX() + 60
                                    && this.getY() + 60 >= otherEnemyTank.getY()
                                    && this.getY() + 60 <= otherEnemyTank.getY() + 40) {
                                return true;
                            }

                            if (this.getX() + 40 >= otherEnemyTank.getX()
                                    && this.getX() + 40 <= otherEnemyTank.getX() + 60
                                    && this.getY() + 60 >= otherEnemyTank.getY()
                                    && this.getY() + 60 <= otherEnemyTank.getY() + 40) {
                                return true;
                            }
                        }
                    }
                }
                break;
            case 3:
                for (int j = 0; j < enemyTanks.size(); j++) {
                    EnemyTank otherEnemyTank = enemyTanks.get(j);
                    if (enemyTanks.get(j) != this) {
                        if (otherEnemyTank.getDirection() == 0 || otherEnemyTank.getDirection() == 2) {
                            if (this.getX() >= otherEnemyTank.getX()
                                    && this.getX() <= otherEnemyTank.getX() + 40
                                    && this.getY() >= otherEnemyTank.getY()
                                    && this.getY() <= otherEnemyTank.getY() + 60
                            ) {
                                return true;
                            }
                            if (this.getY() + 40 >= otherEnemyTank.getY()
                                    && this.getY() + 40 <= otherEnemyTank.getY() + 60
                                    && this.getX() >= otherEnemyTank.getX()
                                    && this.getX() <= otherEnemyTank.getX() + 40) {
                                return true;
                            }
                        }
                        if (otherEnemyTank.getDirection() == 1 || otherEnemyTank.getDirection() == 3) {
                            if (this.getX() >= otherEnemyTank.getX()
                                    && this.getX() <= otherEnemyTank.getX() + 60
                                    && this.getY() >= otherEnemyTank.getY()
                                    && this.getY() <= otherEnemyTank.getY() + 40
                            ) {
                                return true;
                            }
                            if (this.getY() + 40 >= otherEnemyTank.getY()
                                    && this.getY() + 40 <= otherEnemyTank.getY() + 40
                                    && this.getX() >= otherEnemyTank.getX()
                                    && this.getX() <= otherEnemyTank.getX() + 60
                            ) {
                                return true;
                            }
                        }
                    }
                }
                break;
        }
        return false;
    }

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
        collided();
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
                        if (!collided()) {
                            MoveUp();
                        }
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
                        if (!collided()) {
                            MoveRight();
                        }
                        try {
                            Thread.sleep(50);
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }
                }
                case 2 -> {
                    for (int i = 0; i < 30; i++) {
                        if (!collided()) {
                            MoveDown();
                        }
                        try {
                            Thread.sleep(50);
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }
                }
                case 3 -> {
                    for (int i = 0; i < 30; i++) {
                        if (!collided()) {
                            MoveLeft();
                        }
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

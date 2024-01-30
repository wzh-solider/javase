package com.hspedu.tankgame04;

import java.util.Vector;

/**
 * @author Solider
 * @version 1.0
 * 自己的坦克
 */
public class Hero extends Tank {
    // 创建一个空的射击类 <==> 未装子弹
    Fire fire = null;

    public void fireToEnemyTank() {
        // 按不同方向填充子弹
        switch (getDirection()) {
            case 0 -> fire = new Fire(getX() + 20, getY(), getDirection());
            case 1 -> fire = new Fire(getX() + 60, getY() + 20, getDirection());
            case 2 -> fire = new Fire(getX() + 20, getY() + 60, getDirection());
            case 3 -> fire = new Fire(getX(), getY() + 20, getDirection());
        }
        // 开启线程 <==> 开火
        new Thread(fire).start();
    }

    public Hero(int x, int y) {
        super(x, y);
    }

}

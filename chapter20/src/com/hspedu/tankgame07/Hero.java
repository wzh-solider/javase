package com.hspedu.tankgame07;

import java.util.Vector;

/**
 * @author Solider
 * @version 1.0
 * 自己的坦克
 */
public class Hero extends Tank {
    // 创建一个空的射击类 <==> 未装子弹
    Fire fire = null;
    // 创建vector集合，用来存放hero的子弹
    Vector<Fire> fires = new Vector<>();

    public void fireToEnemyTank() {
        // 控制在游戏中，场上存在的子弹数量不能多于五颗
//        if (fires.size() == 5) {
//            return;
//        }

        // 按不同方向填充子弹
        switch (getDirection()) {
            case 0 -> fire = new Fire(getX() + 20, getY(), getDirection());
            case 1 -> fire = new Fire(getX() + 60, getY() + 20, getDirection());
            case 2 -> fire = new Fire(getX() + 20, getY() + 60, getDirection());
            case 3 -> fire = new Fire(getX(), getY() + 20, getDirection());
        }

        // 将子弹加入到集合中
        fires.add(fire);
        // 开启线程 <==> 开火
        new Thread(fire).start();
    }

    public Hero(int x, int y) {
        super(x, y);
    }

}

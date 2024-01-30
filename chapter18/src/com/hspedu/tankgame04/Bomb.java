package com.hspedu.tankgame04;

/**
 * @author Solider
 * @version 1.0
 * 爆炸效果类
 */
public class Bomb {
    private int x, y; // 爆炸的(x, y)坐标
    private int life = 12; // 爆炸的生命周期
    private boolean isLive = true;

    public int getX() {
        return x;
    }

    public void setLive(boolean live) {
        isLive = live;
    }

    public int getY() {
        return y;
    }

    public int getLife() {
        return life;
    }

    public void setLife(int life) {
        this.life = life;
    }

    public Bomb(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void liveDown() {
        if(life > 0) {
            life--;
        } else {
            isLive = false;
        }
    }
}

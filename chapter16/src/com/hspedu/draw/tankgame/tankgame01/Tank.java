package com.hspedu.draw.tankgame.tankgame01;

/**
 * @version 1.0
 * @author Solider
 */
public class Tank {
    private int x; // 坦克横坐标
    private int y; // 坦克纵坐标
    private int direction; // 坦克方向

    public int getX() {
        return x;
    }

    public int getDirection() {
        return direction;
    }

    public void setDirection(int direction) {
        this.direction = direction;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public Tank(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

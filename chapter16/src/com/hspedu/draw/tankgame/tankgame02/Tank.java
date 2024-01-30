package com.hspedu.draw.tankgame.tankgame02;

/**
 * @version 1.0
 * @author Solider
 */
public class Tank {
    private int x; // 坦克横坐标
    private int y; // 坦克纵坐标
    private int direction; // 坦克的方向
    private int speed = 1; // 坦克的运动速度

    public int getDirection() {
        return direction;
    }

    public void setDirection(int direction) {
        this.direction = direction;
    }

    public int getX() {
        return x;
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

    public void MoveUp() {
        y -= speed;
    }

    public void MoveRight() {
        x += speed;
    }

    public void MoveDown() {
        y += speed;
    }

    public void MoveLeft() {
        x -= speed;
    }
}

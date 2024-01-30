package com.hspedu.tankgame05;

/**
 * @author Solider
 * @version 1.0
 */
public class Tank {
    private int x; // 坦克横坐标
    private int y; // 坦克纵坐标
    private int direction; // 坦克的方向
    private int speed = 1; // 坦克的运动速度
    private boolean loop = true;

    public void setLoop(boolean loop) {
        this.loop = loop;
    }

    public boolean isLoop() {
        return loop;
    }

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

    // 设置坦克的运动方向，并将运动区域限制在游戏区域中
    public void MoveUp() {
        if (y > 0) {
            y -= speed;
        }
    }
    public void MoveRight() {
        if (x + 60 < 1000) {
            x += speed;
        }
    }
    public void MoveDown() {
        if (y + 60 < 700) {
            y += speed;
        }
    }
    public void MoveLeft() {
        if (x > 0) {
            x -= speed;
        }
    }
}

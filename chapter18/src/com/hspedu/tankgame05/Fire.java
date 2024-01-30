package com.hspedu.tankgame05;

/**
 * @author Solider
 * @version 1.0
 */
public class Fire implements Runnable {
    private int x; // 子弹的横坐标
    private int y; // 子弹的纵坐标
    private int direction; // 子弹的射击方向(0, 1, 2, 3 ==> 上, 右, 下, 左)
    private int speed = 3; // 子弹的移动速度
    private boolean loop = true; // 判断子弹是否销毁

    public boolean isLoop() {
        return loop;
    }

    public void setLoop(boolean loop) {
        this.loop = loop;
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

    // 初始化子弹的参数
    public Fire(int x, int y, int direction) {
        this.x = x;
        this.y = y;
        this.direction = direction;
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

    @Override
    public void run() {
        while (true) {
            switch (direction) {
                case 0 -> MoveUp();
                case 1 -> MoveRight();
                case 2 -> MoveDown();
                case 3 -> MoveLeft();
            }
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            if (!((x < 1000 && x > 0) && (y < 700 && y > 0) && isLoop())) {
                System.out.println("子弹线程结束");
                loop = false;
                break;
            }
        }
    }
}

package com.hspedu.draw.tankgame.tankgame01;

import javax.swing.*;
import java.awt.*;

/**
 * @author Solider
 * @version 1.0
 * 坦克大战的绘图区域
 */
@SuppressWarnings({"all"})
public class MyPanel extends JPanel {
    // 定义我的坦克
    Hero hero = null;
    public MyPanel() {
        // 初始化坦克
        hero = new Hero(100, 100);
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        // 填充游戏区域
        g.fillRect(0, 0, 1000, 700);
        // 自己的坦克（青色）
        drawTank(hero.getX(), hero.getY(), g, 0, 0);
        // 敌人的坦克（黄色）
        // drawTank(hero.getX() + 60, hero.getY(), g, 0, 1);
    }

    /**
     *
     * @param x 坦克左上角横坐标
     * @param y 纵坐标
     * @param g 传入的图形类（画笔）
     * @param direction 坦克的移动方向
     * @param type 坦克类型
     */
    public void drawTank(int x, int y, Graphics g, int direction, int type) {
        switch (type) {
            case 0 :
                g.setColor(Color.cyan);
                break;
            case 1 :
                g.setColor(Color.yellow);
                break;
        }
        switch (direction) {
            case 0 :
                g.fill3DRect(x, y, 10, 60, false); // 坦克左轮
                g.fill3DRect(x + 30, y, 10, 60, false); // 坦克右轮
                g.fill3DRect(x + 10, y + 10, 20, 40, false); // 坦克方盖
                g.fillOval(x + 10, y + 20, 20, 20); // 坦克圆盖
                g.drawLine(x + 20, y + 30, x + 20, y); // 坦克炮筒
                break;
            case 1 :
                System.out.println("未发生事件");
                break;
        }
    }
}

package com.hspedu.draw.tankgame.tankgame02;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Vector;

/**
 * @author Solider
 * @version 1.0
 * 坦克大战的绘图区域
 */
@SuppressWarnings({"all"})
public class MyPanel extends JPanel implements KeyListener {
    // 定义我的坦克
    Hero hero = null;
    // 定义敌人的坦克
    // 由于敌方坦克较多，所以可能会出现多线程问题，所以使用Vector集合会比较安全
    Vector<EnemyTank> enemyTanks = new Vector<>();
    int enemyTankSize = 3; // 规定敌人坦克的数量

    public MyPanel() {
        // 初始化自己的坦克
        hero = new Hero(100, 100);
        // 初始化敌人的坦克
        for (int i = 0; i < enemyTankSize; i++) {
            // 创建敌方坦克
            EnemyTank enemyTank = new EnemyTank(100 * (i + 1), 0);
            // 设置坦克朝向
            enemyTank.setDirection(2);
            // 将敌方坦克加入到集合中
            enemyTanks.add(enemyTank);
        }
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        // 填充游戏区域
        g.fillRect(0, 0, 1000, 700);
        // 画出自己的坦克（青色）
        drawTank(hero.getX(), hero.getY(), g, hero.getDirection(), 1);
        // 画出敌人的坦克（黄色）
        for (int i = 0; i < enemyTanks.size(); i++) {
            EnemyTank enemyTank = enemyTanks.get(i);
            drawTank(enemyTank.getX(), enemyTank.getY(), g, enemyTank.getDirection(), 0);
        }
    }

    /**
     * @param x         坦克左上角横坐标
     * @param y         纵坐标
     * @param g         传入的图形类（画笔）
     * @param direction 坦克的移动方向
     * @param type      坦克类型
     */
    public void drawTank(int x, int y, Graphics g, int direction, int type) {
        switch (type) {
            // 敌人的坦克
            case 0:
                g.setColor(Color.yellow);
                break;
            // 自己的坦克
            case 1:
                g.setColor(Color.cyan);
                break;
        }
        switch (direction) {
            // 向上
            case 0:
                g.fill3DRect(x, y, 10, 60, false); // 坦克左轮
                g.fill3DRect(x + 30, y, 10, 60, false); // 坦克右轮
                g.fill3DRect(x + 10, y + 10, 20, 40, false); // 坦克方盖
                g.fillOval(x + 10, y + 20, 20, 20); // 坦克圆盖
                g.drawLine(x + 20, y + 30, x + 20, y); // 坦克炮筒
                break;
            // 向右
            case 1:
                g.fill3DRect(x, y, 60, 10, false); // 坦克左轮
                g.fill3DRect(x, y + 30, 60, 10, false); // 坦克右轮
                g.fill3DRect(x + 10, y + 10, 40, 20, false); // 坦克方盖
                g.fillOval(x + 20, y + 10, 20, 20); // 坦克圆盖
                g.drawLine(x + 30, y + 20, x + 60, y + 20); // 坦克炮筒
                break;
            // 向下
            case 2:
                g.fill3DRect(x, y, 10, 60, false); // 坦克左轮
                g.fill3DRect(x + 30, y, 10, 60, false); // 坦克右轮
                g.fill3DRect(x + 10, y + 10, 20, 40, false); // 坦克方盖
                g.fillOval(x + 10, y + 20, 20, 20); // 坦克圆盖
                g.drawLine(x + 20, y + 30, x + 20, y + 60); // 坦克炮筒
                break;
            // 向左
            case 3:
                g.fill3DRect(x, y, 60, 10, false); // 坦克左轮
                g.fill3DRect(x, y + 30, 60, 10, false); // 坦克右轮
                g.fill3DRect(x + 10, y + 10, 40, 20, false); // 坦克方盖
                g.fillOval(x + 20, y + 10, 20, 20); // 坦克圆盖
                g.drawLine(x + 30, y + 20, x, y + 20); // 坦克炮筒
                break;
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_W:
                hero.MoveUp();
                hero.setDirection(0);
                break;
            case KeyEvent.VK_D:
                hero.MoveRight();
                hero.setDirection(1);
                break;
            case KeyEvent.VK_S:
                hero.MoveDown();
                hero.setDirection(2);
                break;
            case KeyEvent.VK_A:
                hero.MoveLeft();
                hero.setDirection(3);
                break;
        }
        this.repaint();
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}

package com.hspedu.tankgame07;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.util.Vector;
import java.util.concurrent.Future;

/**
 * @author Solider
 * @version 1.0
 * 坦克大战的绘图区域
 */
@SuppressWarnings({"all"})
// 实现监听接口，和 Runnable接口使得MyPanel类作为线程启动
public class MyPanel extends JPanel implements KeyListener, Runnable {
    // 定义我的坦克
    Hero hero = null;

    // 定义敌人的坦克
    // 由于敌方坦克较多，所以可能会出现多线程问题，所以使用Vector集合会比较安全
    Vector<EnemyTank> enemyTanks = new Vector<>();
    int enemyTankSize = 6; // 规定敌人坦克的数量
    // 定义一个集合，接收Node节点对象的数据
    Vector<Node> nodes = new Vector<>();

    // 由于存在多颗子弹 同时 打到多个坦克触发多个爆炸效果，所以使用Vector集合存放爆炸效果
    Vector<Bomb> bombs = new Vector<>();
    // 定义爆炸的效果
    Image image1 = null;
    Image image2 = null;
    Image image3 = null;

    public MyPanel(int key) {
        // 如果选择继续游戏，就读取上局记录
        File file = new File(Recorder.getRecordFile());
        if(file.exists()) {
            nodes = Recorder.getNodeInfoAndAllEnemyTankNum();
        } else {
            System.out.println("文件不存在，开启新游戏。。。");
            key = 1;
        }
        // 判断是新开游戏，还是继续上局游戏
        switch (key) {
            case 1 ->{
                // 初始化敌人的坦克
                for (int i = 0; i < enemyTankSize; i++) {
                    // 创建敌方坦克
                    EnemyTank enemyTank = new EnemyTank(100 * (i + 1), 0);
                    enemyTank.setEnemyTanks(enemyTanks);
                    // 设置坦克初始朝向
                    enemyTank.setDirection(2);
                    // 开启敌方坦克线程，使得敌方坦克可以自由移动
                    new Thread(enemyTank).start();
                    // 将敌方坦克加入到集合中
                    enemyTanks.add(enemyTank);
                    Recorder.setEnemyTanks(enemyTanks);
                    Recorder.setAllEnemyTankNum(0);
                }
            }
            case 2 -> {
                for (int i = 0; i < nodes.size(); i++) {
                    Node node = nodes.get(i);
                    // 循环遍历敌方坦克
                    EnemyTank enemyTank = new EnemyTank(node.getX(), node.getY());
                    enemyTank.setEnemyTanks(enemyTanks);
                    enemyTank.setDirection(node.getDirection());
                    new Thread(enemyTank).start();
                    enemyTanks.add(enemyTank);
                    Recorder.setEnemyTanks(enemyTanks);
                }
            }
        }
        // 初始化自己的坦克
        hero = new Hero(800, 100);


        // 初始化图片
        image1 = Toolkit.getDefaultToolkit().getImage(MyPanel.class.getResource("/boom_1.png"));
        image2 = Toolkit.getDefaultToolkit().getImage(MyPanel.class.getResource("/boom_2.png"));
        image3 = Toolkit.getDefaultToolkit().getImage(MyPanel.class.getResource("/boom_3.png"));
        // 创建读取音乐的线程
        new AePlayWave("src//3240187607.wav").start();
    }


    // 定义一个方法，记录玩家数据
    public void showInfo(Graphics g) {
        // 初始化画笔的颜色，字体，和大小
        g.setColor(Color.BLACK);
        Font font = new Font("宋体", Font.BOLD, 25);
        g.setFont(font);
        g.drawString("累计击毁敌方坦克数", 1020, 30);
        //画出敌方坦克的模型
        drawTank(1020, 50, g, 0, 0);
        // 因为在画坦克时，将画笔设置为了坦克的颜色，所以需要重置画笔
        g.setColor(Color.BLACK);
        g.drawString( Recorder.getAllEnemyTankNum() + "", 1080, 90);
    }
    @Override
    public void paint(Graphics g) {
        super.paint(g);
        // 填充游戏区域
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, 1000, 700);
        // 调用方法，记录玩家成绩
        showInfo(g);
        // 当己方坦克不为空，且生命周期存在时，画出自己的坦克（青色）
        if (hero != null && hero.isLoop()) {
            drawTank(hero.getX(), hero.getY(), g, hero.getDirection(), 1);
        }
        // 遍历画出敌人的坦克（黄色）
        for (int i = 0; i < enemyTanks.size(); i++) {
            EnemyTank enemyTank = enemyTanks.get(i);
            // 判断敌方坦克的生命周期
            if (enemyTank.isLoop()) {
                //当敌方坦克生命周期存在时，才画出敌方坦克
                drawTank(enemyTank.getX(), enemyTank.getY(), g, enemyTank.getDirection(), 0);
                // 循环遍历出敌方坦克的子弹数
                for (int j = 0; j < enemyTank.fires.size(); j++) {
                    Fire fire = enemyTank.fires.get(j);
                    // 判断子弹的生命周期
                    if (fire.isLoop()) {
                        // 如果子弹生命周期存在，才画出该子弹
                        g.fillRect(fire.getX(), fire.getY(), 2, 2);
                    } else {
                        // 否则将该子弹从坦克弹药库中删除
                        enemyTank.fires.remove(fire);
                    }
                }
            }
        }

        // 遍历出爆炸效果
        for (int i = 0; i < bombs.size(); i++) {
            // 每次画出爆炸效果休眠40毫秒
            try {
                Thread.sleep(40);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            // 取出炸弹
            Bomb bomb = bombs.get(i);
            // 通过判断爆炸的生命周期，画出相应的爆炸效果
            if (bomb.getLife() > 9) {
                g.drawImage(image1, bomb.getX(), bomb.getY(), 60, 60, this);
            } else if (bomb.getLife() > 6) {
                g.drawImage(image2, bomb.getX(), bomb.getY(), 60, 60, this);
            } else if (bomb.getLife() > 3) {
                g.drawImage(image3, bomb.getX(), bomb.getY(), 60, 60, this);
            }
            // 每画出一次爆炸效果，使得爆炸的生命周期 -1
            bomb.liveDown();


            // 判断爆炸的生命周期是否归0
            if (bomb.getLife() == 0) {
                bombs.remove(bomb);
            }
        }

        // 遍历出所有己方打出的子弹，并画出子弹
        for (int i = 0; i < hero.fires.size(); i++) {
            Fire fire = hero.fires.get(i);
            // 如果子弹存在，且子弹的生命周期为真，就画出该子弹，否则将该子弹从集合总删除
            if (fire != null && fire.isLoop() == true) {
                g.fillRect(fire.getX(), fire.getY(), 2, 2);
            } else {
                hero.fires.remove(fire);
            }
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

    // 遍历出所有的子弹，以防止当发射出一连串子弹时，子弹碰触到坦克时，坦克无响应（不爆炸）
    public void hitEnemyTank() {
        // 遍历出所有己方发射出的子弹
        for (int j = 0; j < hero.fires.size(); j++) {
            Fire fire = hero.fires.get(j);
            if (fire != null && fire.isLoop()) {
                // 如果子弹不为空，且生命周期为真，就遍历所有的敌方坦克
                for (int i = 0; i < enemyTanks.size(); i++) {
                    EnemyTank enemyTank = enemyTanks.get(i);
                    // 判断子弹是否杀掉坦克
                    hitTank(fire, enemyTank);
                }
            }
        }
    }
    public void hitHeroTank() {
        // 遍历出敌方坦克
        for (int i = 0; i < enemyTanks.size(); i++) {
            EnemyTank enemyTank = enemyTanks.get(i);
            // 遍历出敌方坦克发射的所有子弹
            for(int j = 0; j <enemyTank.fires.size(); j++) {
                Fire fire = enemyTank.fires.get(j);
                hitTank(fire, hero);
            }
        }
    }

    // 创建一个坦克消亡的方法
    public void hitTank(Fire fire, Tank tank) {
        // 根据坦克的方向，判断子弹可以打到坦克的范围
        switch (tank.getDirection()) {
            case 0: // 向上
            case 2: // 向下
                if (fire.getX() > tank.getX() && fire.getX() < tank.getX() + 40 &&
                        fire.getY() > tank.getY() && fire.getY() < tank.getY() + 60) {
                    // 如果打到，则使得子弹生命周期结束
                    fire.setLoop(false);
                    // 坦克生命周期结束
                    tank.setLoop(false);
                    // 判断，传入的坦克为敌方坦克时，才进行删除
                    if (tank instanceof EnemyTank) {
                        enemyTanks.remove(tank);
                        Recorder.addAllEnemyTankNum();
                    }
                    // 打到坦克后，创建爆炸效果，并将其添加到集合中
                    Bomb bomb = new Bomb(tank.getX(), tank.getY());
                    bombs.add(bomb);
                }
            case 1: // 向右
            case 3: // 向左
                if (fire.getX() > tank.getX() && fire.getX() < tank.getX() + 60 &&
                        fire.getY() > tank.getY() && fire.getY() < tank.getY() + 40) {
                    fire.setLoop(false);
                    tank.setLoop(false);
                    if (tank instanceof EnemyTank) {
                        enemyTanks.remove(tank);
                        Recorder.addAllEnemyTankNum();
                    }
                    Bomb bomb = new Bomb(tank.getX(), tank.getY());
                    bombs.add(bomb);
                }
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
            case KeyEvent.VK_J:
                hero.fireToEnemyTank();
                break;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    @Override
    public void run() {
        // 线程运行过程中，每隔10毫秒重绘一次面板
        while (true) {
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            hitEnemyTank();
            hitHeroTank();
            this.repaint();
        }
    }
}

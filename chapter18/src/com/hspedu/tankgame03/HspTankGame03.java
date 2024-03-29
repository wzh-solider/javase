package com.hspedu.tankgame03;

import javax.swing.*;

/**
 * @author Solider
 * @version 1.0
 */
public class HspTankGame03 extends JFrame {
    // 定义一个空的画板
    MyPanel myPanel = null;

    public static void main(String[] args) {
        HspTankGame03 hspTankGame01 = new HspTankGame03();
    }
    // 构造器，初始化游戏区域
    public HspTankGame03() {
        myPanel = new MyPanel(); // 初始化画板
        // 启动线程
        new Thread(myPanel).start();
        // 将画板放置到窗口内
        this.add(myPanel);
        // 设置窗口
        this.setSize(1000, 700);
        // 监听键盘事件
        this.addKeyListener(myPanel);
        // 关闭窗口后，程序即停止运行
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // 可视化窗口
        this.setVisible(true);
    }
}

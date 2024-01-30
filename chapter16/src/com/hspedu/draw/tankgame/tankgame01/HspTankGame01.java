package com.hspedu.draw.tankgame.tankgame01;

import javax.swing.*;

/**
 * @author Solider
 * @version 1.0
 */
public class HspTankGame01 extends JFrame {
    // 定义一个空的画板
    MyPanel myPanel = null;

    public static void main(String[] args) {
        HspTankGame01 hspTankGame01 = new HspTankGame01();
    }
    // 构造器，初始化游戏区域
    public HspTankGame01() {
        myPanel = new MyPanel(); // 初始化画板
        this.add(myPanel); // 将画板放置到窗口内
        // 设置窗口
        this.setSize(1000, 700);
        // 关闭窗口后，程序即停止运行
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // 可视化窗口
        this.setVisible(true);
    }
}

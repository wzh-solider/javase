package com.hspedu.tankgame06;

import javax.swing.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Scanner;

/**
 * @author Solider
 * @version 1.0
 */
public class HspTankGame06 extends JFrame {
    // 定义一个空的画板
    MyPanel myPanel = null;

    public static void main(String[] args) {
        HspTankGame06 hspTankGame01 = new HspTankGame06();
    }
    // 构造器，初始化游戏区域
    public HspTankGame06() {
        // 在游戏区域中，提示是否进行新游戏
        Scanner scanner = new Scanner(System.in);
        System.out.println("请选择：1、新游戏  2、继续游戏");
        int key = scanner.nextInt();
        // 初始化画板
        myPanel = new MyPanel(key);
        // 启动线程
        new Thread(myPanel).start();
        // 将画板放置到窗口内
        this.add(myPanel);
        // 设置窗口
        this.setSize(1300, 700);
        // 监听键盘事件
        this.addKeyListener(myPanel);
        // 监听窗口响应事件
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                // 当窗口正在关闭时，将玩家成绩进行写入文件
                Recorder.record();
                System.exit(0);
            }
        });
        // 关闭窗口后，程序即停止运行
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // 可视化窗口
        this.setVisible(true);
    }
}

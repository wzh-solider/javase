package com.hspedu.draw;

import javax.swing.*;
import java.awt.*;

@SuppressWarnings({"all"})
public class DrawCircle extends JFrame {// JFrame是一个窗口，相当于一个画框
    // 首先定义一个面板
    MyPanel myPanel =  null;
    public static void main(String[] args) {
        new DrawCircle();
    }

    public DrawCircle() {
        // 初始化面板
        myPanel = new MyPanel();
        // 将面板放入窗口
        this.add(myPanel);
        // 设置面板大小
        this.setSize(400, 300);
        // 规定界面退出，程序结束
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // 可显示
        this.setVisible(true);

    }
}

// 定义一个 MyPanel(画板类)，继承 JPanel类
class MyPanel extends JPanel  {
    // 重写 JPanel 中的 paint方法
    // Graphics g ==> 相当于一支画笔
    @Override
    public void paint(Graphics g) {
        // 调用父类方法，完成初始化
        super.paint(g);
        // 设置画笔的字体
        g.setFont(new Font("隶书", Font.BOLD, 50));
        // 设置画笔的颜色
        g.setColor(Color.BLUE);
        // 调用Graphics图形类中的方法，初始化一个圆
        g.drawOval(10, 10, 100, 100);
        // 填充椭圆
        g.fillOval(270, 10, 100, 100);
        // 初始化直线
        g.drawLine(10, 150, 200, 150);
        // 矩形
        g.drawRect(150, 10, 100, 50);
        // 填充矩形
        g.fillRect(150, 70, 100, 50);
        // 字符串
        g.drawString("Jack", 10, 200);
        // 图片
        Image image = Toolkit.getDefaultToolkit().getImage(MyPanel.class.getResource("/4c2f28d1843727c80b155cbd4828e8d.jpg"));
        g.drawImage(image, 10, 10, 159, 160, this);
    }
}

package com.hspedu.draw.event_;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * @author Solider
 * @version 1.0
 */
public class BallMove extends JFrame {
    MyPanel myPanel = null;
    public static void main(String[] args) {
        new BallMove();
    }

    public BallMove() {
        myPanel = new MyPanel();
        this.add(myPanel);
        this.setSize(500, 400);
        this.addKeyListener(myPanel);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }
}
class MyPanel extends JPanel implements KeyListener {
    int x = 100;
    int y = 100;

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.fillOval(x, y, 20, 20);
    }

    // 当字符串输出时，该方法触发
    @Override
    public void keyTyped(KeyEvent e) {

    }

    // 当某个键被按下时，该方法触发
    @Override
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_DOWN -> y++;
            case KeyEvent.VK_UP -> y--;
            case KeyEvent.VK_RIGHT -> x++;
            case KeyEvent.VK_LEFT -> x--;
        }
        this.repaint();
    }

    // 当某个键被释放时，该方法触发
    @Override
    public void keyReleased(KeyEvent e) {

    }
}

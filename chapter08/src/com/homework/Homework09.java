package com.homework;

public class Homework09 {
    public static void main(String[] args) {
        Point p = new LabeledPoint("Black Thursday", 1929, 230.07);
        LabeledPoint L = (LabeledPoint)p;
        System.out.println(L.show());
    }
}

class Point {
    double x;
    double y;
    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }
}

class LabeledPoint extends Point {
    String lable;
    public LabeledPoint(String lable, double x, double y) {
        super(x, y);
        this.lable = lable;
    }

    public String show() {
        return "标签值：" + lable + "\t坐标：(" + super.x + "," + super.y + ")";
    }
}

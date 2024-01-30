package com.hspedu.homework;

public class Homework08 {
    public static void main(String[] args) {
        for(Color color : Color.values()) {
            System.out.println(color.name());
            color.show();
            System.out.print(color.ordinal());
        }
        int i = Color.RED.compareTo(Color.BLUE);
        System.out.println(i);
        Color color = Color.BLACK;
        switch (color) {
            case RED :
                System.out.println("匹配到红色");
                break;
            case BLACK:
                System.out.println("匹配到黑色");
                break;
            default :
                System.out.println("没有匹配到");
        }
    }
}
interface Show {
    void show();
}
enum Color implements Show{
    RED(255, 0, 0), BLUE(0, 0, 255),
    BLACK(0, 0, 0), YELLOW(255, 255, 0),
    GREEN(0, 255, 0);
    private int redValue;
    private int greenValue;
    private int blueValue;
    private Color(int redValue, int greenValue, int blueValue) {
        this.redValue = redValue;
        this.greenValue = greenValue;
        this.blueValue = blueValue;
    }
    private Color() {}
    public void show() {
        System.out.println("{" + redValue + ", " + greenValue + ", " + blueValue + "}");
    }
}

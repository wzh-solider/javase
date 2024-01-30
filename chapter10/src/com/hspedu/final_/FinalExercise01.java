package com.hspedu.final_;

public class FinalExercise01 {
    public static void main(String[] args) {
        Circle circle = new Circle(5);
        System.out.println("The Circle area is " + circle.getArea());
    }
}

class Circle {
    private double radius;
    private final double PI;
    {
        PI = 3.14;
    }
    public Circle(double radius) {
        this.radius = radius;
        // PI = 3.14;
    }
    public void setRadius(double radius) { this.radius = radius; }
    public double getRadius() { return radius; }
    public double getArea() {
        return PI * Math.pow(radius, 2);
    }
}

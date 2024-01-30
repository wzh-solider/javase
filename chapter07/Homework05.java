import java.util.*;

public class Homework05 {
	public static void main(String[] args) {
		Circle c = new Circle(3);
		c.circumference();
		c.area();
	}
}

class Circle {
	int radius;
	public Circle(int radius) {
		this.radius = radius;
	}
	public void circumference() {
		System.out.println("圆的周长：" + 2 * Math.PI * this.radius);
	}
	public void area() {
		System.out.println("圆的面积：" + Math.PI * Math.pow(this.radius, 2));
	}
}
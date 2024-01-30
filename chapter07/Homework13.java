public class Homework13 {
	public static void main(String[] args) {
		PassObject p = new PassObject();
		p.printAreas(new Circle(), 5);
	}
}

class Circle {
	double radius = 1;
	public double findArea() {
		return Math.PI * Math.pow(radius, 2);
	}
}

class PassObject {
	public void printAreas(Circle c, int times) {
		System.out.println("Radius" + "\t" + "Area");
		for (int i = 1; i <= times; i++) {
			System.out.println(c.radius + "\t" + c.findArea());
			c.radius++;
		}
	}
}
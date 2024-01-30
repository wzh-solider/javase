public class Homework07 {
	public static void main(String[] args) {
		Dog d = new Dog("Ð¡°×", 18, "°×É«");
		d.show();
	}
}

class Dog {
	String name;
	int age;
	String color;
	public Dog(String name, int age, String color) {
		this.name = name;
		this.age = age;
		this.color = color;
	}
	public void show() {
		System.out.println("name: " + this.name);
		System.out.println("age: " + this.age);
		System.out.println("color: " + this.color);
	}
}
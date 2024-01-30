public class ConstructorExercise {
	public static void main(String[] args) {
		Person p1 = new Person();
		Person p2 = new Person("–°¿Ó", 19);
		System.out.println("p1 = " + p1.age);
		System.out.println("p2 = " + p2.name + p2.age);
	}
}

class Person {
	String name;
	int age;
	public Person() { this.age = 18; }
	public Person(String pName, int pAge) {
		name = pName;
		age = pAge;
	}
}
public class TestPerson {
	public static void main(String[] args) {
		Person p = new Person("小李", 18);
		Person p1 = new Person("小李", 19);
		boolean b = p.compareTo(p1);
		System.out.println("两个人身份为：" + b);
	}
}

class Person {
	String name;
	int age;
	public Person(String name, int age) {
		this.name = name;
		this.age = age;
	}
	public boolean compareTo(Person p) {
		return this.name.equals(p.name) && this.age == p.age;
	}
}
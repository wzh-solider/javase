public class Homework12 {
	public static void main(String[] args) {
		Employee e = new Employee("jian", 'm', 18, "Õı¿Ô", 1903.3);
		System.out.println("name = " + e.name);
		System.out.println("sex = " + e.sex);
		System.out.println("age = " + e.age);
		System.out.println("job = " + e.job);
		System.out.println("salary = " + e.salary);
	}
}

class Employee {
	String name;
	char sex;
	int age;
	String job;
	double salary;
	public Employee(String job, double salary) {
		this.job = job;
		this.salary = salary;
	}
	public Employee(String name, char sex, int age) {
		this.name = name;
		this.sex = sex;
		this.age = age;
	}
	public Employee(String name, char sex, int age, String job, double salary) {
		this(name, sex, age);
		this.job = job;
		this.salary = salary;
	}
}
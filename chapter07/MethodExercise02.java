public class MethodExercise02 {
	public static void main(String[] args) {
		int[][] arr = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
		Mytools print = new Mytools();
		print.printDouArray(arr);
		Mytools person = new Mytools();
		person.name = "Ð¡°×";
		person.age = 18;
		person.copyPerson(person);
		System.out.println("person.name = " + person.name + "\n" + "person.age" + person.age);
	}
}

class Mytools {
	String name;
	int age;
	public void printDouArray(int[][] arr) {
		for (int i = 0; i < arr.length; i++){
			for (int j = 0; j < arr[i].length; j++)
				System.out.print(arr[i][j] + " ");
			System.out.println();
		}
	}
	public void copyPerson(Mytools p) {
		Mytools newPerson = new Mytools();
		newPerson.name = p.name;
		newPerson.age = p.age;
		System.out.println("newPerson.name = " + newPerson.name + "\n" + "newPerson.age = " + newPerson.age);
	}
}
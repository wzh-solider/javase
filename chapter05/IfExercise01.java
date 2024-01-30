import java.util.Scanner;

public class IfExercise01 {
	public static void main(String[] args) {
		double n1 = 2.3;
		double n2 = 2.4;
		if (n1 > 10.0 && n2 < 20.0) {
			double sum = n1 + n2;
			System.out.println(sum);
		} else {
			double n3 = n1 - n2;
			System.out.println(n3); 
		}

		System.out.println("ÇëÊäÈëÄê·Ý£º");
		Scanner MyScanner = new Scanner(System.in);
		int year = MyScanner.nextInt();
		if ((year % 100 != 0 && year % 4 == 0) || year % 400 == 0) {
			System.out.println("Yes!");
		} else System.out.println("No!");

	}
}
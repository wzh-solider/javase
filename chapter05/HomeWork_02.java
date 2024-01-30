import java.util.Scanner;

public class HomeWork_02 {
	public static void main(String[] args) {
		Scanner myScanner = new Scanner(System.in);
		int num = myScanner.nextInt();
		if (num > 0){
			System.out.println(num + ">0");
		} else if (num == 0) {
			System.out.println(num + "=0");
		} else System.out.println(num + "<0");
	}
}
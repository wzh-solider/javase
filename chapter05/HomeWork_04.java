import java.util.Scanner;

public class HomeWork_04 {
	public static void main(String[] args) {
		Scanner myScanner = new Scanner(System.in);
		int num = myScanner.nextInt();
		int hunderds = (num / 100);
		int decade = (num / 10) % 10;
		int unit = num % 10;
		int num2 = hunderds * hunderds * hunderds + decade * decade * decade + unit * unit * unit;
		if (num == num2)
			System.out.println(num + "是水仙花数");
		else System.out.println(num + "不是水仙花数");
	}
}
import java.util.*;

public class ArrayReduce {
	public static void main(String[] args) {
		int[] arr = {1, 2, 3, 4, 5};
		int len = arr.length;
		Scanner myScanner = new Scanner(System.in);
		while(true) {
			if (len == 1) {
				System.out.println("\n" + "数组不可再缩减！");
				break;
			}
			System.out.print("\n" + "是否缩减数组(Y / N):");
			char ch = myScanner.next().charAt(0);
			if (ch == 'Y') {
				System.out.println("====缩减后的数组为====");
				len--;
				for (int i = 0; i < len; i++)
					System.out.print(arr[i]);
			} else break;
		}
		System.out.println("程序退出...");
	}
}				
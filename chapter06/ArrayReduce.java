import java.util.*;

public class ArrayReduce {
	public static void main(String[] args) {
		int[] arr = {1, 2, 3, 4, 5};
		int len = arr.length;
		Scanner myScanner = new Scanner(System.in);
		while(true) {
			if (len == 1) {
				System.out.println("\n" + "���鲻����������");
				break;
			}
			System.out.print("\n" + "�Ƿ���������(Y / N):");
			char ch = myScanner.next().charAt(0);
			if (ch == 'Y') {
				System.out.println("====�����������Ϊ====");
				len--;
				for (int i = 0; i < len; i++)
					System.out.print(arr[i]);
			} else break;
		}
		System.out.println("�����˳�...");
	}
}				
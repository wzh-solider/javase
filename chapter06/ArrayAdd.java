import java.util.*;

public class ArrayAdd {
	public static void main(String[] args) {
		int[] arr = {1, 2, 3};
		Scanner myScanner = new Scanner(System.in);
		do {
			int[] arrNew = new int[arr.length + 1];
			for (int i = 0; i < arr.length; i++) 
				arrNew[i] = arr[i];
			System.out.print("��������Ҫ��ӵ�Ԫ�أ�");
			arrNew[arrNew.length - 1] = myScanner.nextInt();
			arr = arrNew;
			System.out.println("====���ݺ������Ϊ====");
			for (int i = 0; i < arr.length; i++) 
				System.out.print(arr[i]);
			System.out.print("\n" + "�Ƿ�Ҫ��������(Y / N)");
			char ch = myScanner.next().charAt(0);
			if (ch == 'N') break;
		}while(true);
	}
}
import java.util.*;

public class ArrayAdd {
	public static void main(String[] args) {
		int[] arr = {1, 2, 3};
		Scanner myScanner = new Scanner(System.in);
		do {
			int[] arrNew = new int[arr.length + 1];
			for (int i = 0; i < arr.length; i++) 
				arrNew[i] = arr[i];
			System.out.print("请输入所要添加的元素：");
			arrNew[arrNew.length - 1] = myScanner.nextInt();
			arr = arrNew;
			System.out.println("====扩容后的数组为====");
			for (int i = 0; i < arr.length; i++) 
				System.out.print(arr[i]);
			System.out.print("\n" + "是否还要继续扩容(Y / N)");
			char ch = myScanner.next().charAt(0);
			if (ch == 'N') break;
		}while(true);
	}
}
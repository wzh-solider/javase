import java.util.*;

public class SeqSearch {
	public static void main(String[] args) {
		int[] numArr = {1, 8, 10, 89, 1000, 1234};
		int low = 0;
		int high = numArr.length - 1;
		boolean found = false;
		int mid = 0;
		Scanner myScanner = new Scanner(System.in);
		int n = myScanner.nextInt();
		while(low < high) {
			mid = (low + high) / 2;
			if (n == numArr[mid]) {
				found = true; break;
			}
			if (n > mid)
				low = mid + 1;
			else high = mid - 1;
		}
		if (found) System.out.println(mid);
		else System.out.println("没有这个数");
	}
}
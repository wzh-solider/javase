public class HomeWork04 {
	public static void main(String[] args) {
		int[] arr = {10, 12, 45, 90};
		int n = 23;
		int index = -1;
		for (int i = 0; i < arr.length; i++) {
			if (n <= arr[i]) {
				index = i;
				break;
			}
		}
		int[] arrNew = new int[arr.length + 1];
		if (index == -1) index = arr.length;
		else {
			for (int i = 0, j = 0; i < arrNew.length; i++) {
				if (i != index) {
					arrNew[i] = arr[j];
					j++;
				} else arrNew[j] = n;
			}
		}
					for (int k = 0; k < arrNew.length; k++)
			System.out.print(arrNew[k] + " ");
	}
}
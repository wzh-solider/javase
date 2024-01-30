public class YangHui {
	public static void main(String[] args) {
		int[][] arr = new int[10][];
		for (int i = 0; i < 10; i++) {
			arr[i] = new int[i + 1];
			arr[i][0] = 1;
			arr[i][arr[i].length - 1] = 1;
			for (int j = 1; j < arr[i].length - 1 && i != 1; j++)
				arr[i][j] = arr[i - 1][j - 1] + arr[i - 1][j];
		}
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < arr[i].length; j++)
				System.out.print(arr[i][j] + "\t");
			System.out.println();
		}

	}	
}
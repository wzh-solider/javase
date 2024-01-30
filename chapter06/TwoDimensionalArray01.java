public class TwoDimensionalArray01 {
	public static void main(String[] args) {
		int[][] arr = {{0, 0, 0, 0}, {1, 2, 3, 4}, {1,2,3,3}, {4,4,4,4}};
		for (int  i = 0; i < 4; i++){
			for (int j = 0; j < 4; j++) {
				System.out.print(arr[i][j]);
			}
			System.out.println();
		}

	}
}
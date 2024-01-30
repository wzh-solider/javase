public class ForExercise {
	public static void main(String[] args) {
		int i;
		int sum = 0, temp = 0;
		for (i = 1; i <= 100; i++)
			if (i % 9 == 0) {
				sum += i;
				temp++;
			}
			System.out.println("Sum = " + sum);
			System.out.println("Temp = " + temp);
				int j, k;
	for (j = 0, k = 5; j <= 5 & k >= 0; j++, k--)
		System.out.println(j + "+" + k + "=" + (k + j));
	}

}
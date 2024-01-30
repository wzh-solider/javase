public class Homework01 {
	public static void main(String[] args) {
		A01 a = new A01();
		double[] arr = {1, 2, 3, 4, 5};
		double max = a.max(arr);
		System.out.println("max = " + max);
		a.maxPlus(arr);
		System.out.println("maxPlus = " + arr[0]);
	}
}

class A01 {
	public double max(double[] arr) {
		double max = arr[0];
		for (int i = 0; i < arr.length; i++) {
			if (max < arr[i]) max = arr[i];
		}
		return max;
	}

	public void maxPlus(double[] arr) {
		for (int i = 1; i < arr.length; i++)
			for (int j = 0; j < arr.length - i; j++) {
				if (arr[j] < arr[j + 1]) {
					double temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;
				}
			}
	}
}
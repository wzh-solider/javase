public class HomeWork_05 {
	public static void main(String[] args) {
		double sum = 0;
		double n = 1.0;
		for (int i = 1; i <= 100; i++) {
			double a = n / i;
			sum += a;
			n = -n;
		}
		System.out.println("sum = " + sum);
	}
}
public class OverLoad {
	public static void main(String[] args) {
		MyCalculator mc = new MyCalculator();
		int sum1 = mc.calculate(1, 2);
		double sum2 = mc.calculate(1, 2.0);
		double sum3 = mc.calculate(1.0, 2);
		int sum4 = mc.calculate(1, 2, 3);
		System.out.println("" + sum1 + sum2 + sum3 + sum4);
	}
}

class MyCalculator {
	public int calculate(int n1, int n2) {
		return n1 + n2;
	}
	public double calculate(int n1, double n2) {
		return n1 + n2;
	}
	public double calculate(double n1, int n2) {
		return n1 + n2;
	}
	public int calculate(int n1, int n2, int n3) {
		return n1 + n2 + n3;
	}
}
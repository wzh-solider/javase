public class TernaryOperatorExercise {
	public static void main(String[] args) {
		int a = 1;
		int b = 2;
		int c = 3;
		int Max = (a > b ? a : b) > c ? (a > b ? a : b) : c;
		System.out.println("Max = " + Max);
	}
}
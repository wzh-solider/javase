public class Recursion02 {
	public static void main(String[] args) {
		System.out.println("n = " + T1.recursion(3));

	}
}

class T1 {
	public static int recursion(int n) {
		if (n != 1)
			n *= recursion(n - 1);
		return n;
	}
}
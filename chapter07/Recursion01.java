public class Recursion01 {
	public static void main(String[] args) {
		int n = T1.recursion(10);
		System.out.println("n = " + n);
	}
}

class T1 {
	public static int recursion(int n) {
		if (n > 2) 
			n = recursion(n - 1);
		return n;
	}
}
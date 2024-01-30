public class Homework06 {
	public static void main(String[] args) {
		Cale c = new Cale(0, 2);
		c.sum();
		c.subtract();
		c.multiply();
		c.except();
	}
}

class Cale {
	int n1, n2;
	public Cale(int n1, int n2) {
		this.n1 = n1;
		this.n2 = n2;
	}
	public void sum() {
		System.out.println(n1 + n2);
	}
	public void subtract() {
		System.out.println(n1 - n2);
	}

	public void multiply() {
		System.out.println(n1 * n2);
	}

	public void except() {
		if (n1 == 0) System.out.println("ERROR!");
		else System.out.println((double)n1 / n2);
	}

}
public class HanoiTower {
	public static void main(String[] args) {
		T1.move(3, "a", "b", "c");
	}
}

class T1 {
	public static void move(int n, String a, String b, String c) {
		if(n == 1) {
			System.out.println(a + "-->" + c);
		} else {
			move(n - 1, a, c, b);
			System.out.println(a + "-->" + c);
			move(n - 1, b, a, c);
		}
	}
}
import java.util.Random;

public class Homework14 {
	public static void main(String[] args) {
		A14 a = new A14();
		a.guess(1, 2, 0, 0, 1, 2);
	}
}

class A14 {
	public void guess(int... num) {
		Random ran = new Random();
		for (int i = 0; i < num.length; i++) {
			int r = ran.nextInt(3);
			System.out.println("���Գ����ǣ�" + r);
			if (num[i] == r) {
				System.out.println("ƽ��");
			} else if (num[i] == 0) {
				if (r == 1) System.out.println("TomӮ");
				else System.out.println("Tom��");
			} else if (num[i] == 1) {
				if (r == 2) System.out.println("TomӮ");
				else System.out.println("Tom��");
			} else if (num[i] == 2) {
				if (r == 0) System.out.println("TomӮ");
				else System.out.println("Tom��");
			}
		}
	}
}
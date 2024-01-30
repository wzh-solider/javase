public class HomeWork_01 {
	public static void main(String[] args) {
		double money = 100000;
		int t = 0;
		while(true) {
			if (money > 50000){
				money *= 0.95;
				t++;
			} else if (money >= 1000) {
				money -= 1000;
				t++;
			} else break;
		}
		System.out.println("t =" + t);
	}
}
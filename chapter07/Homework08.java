public class Homework08 {
	int count = 9;
	public void count01() {
		count = 10;
		System.out.println("count = " + count);
	}
	public void count02() {
		System.out.println("count = " + count++);
	}
	public static void main(String[] args) {
		new Homework08().count01(); // ����䴴���µĶ���ֱ�ӵ��÷��� ==> ͬʱ�˶����countҲ��Ϊ10
		Homework08 h = new Homework08();
		h.count02();
		h.count02();
	}
}
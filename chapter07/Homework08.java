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
		new Homework08().count01(); // 本语句创建新的对象，直接调用方法 ==> 同时此对象的count也变为10
		Homework08 h = new Homework08();
		h.count02();
		h.count02();
	}
}
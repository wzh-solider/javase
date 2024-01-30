public class Homework02 {
	public static void main(String[] args) {
		String[] str = {"i", "j", "k", "l"};
		A02 a = new A02();
		int rel = a.find(str, "k");
		System.out.println("rel = " + rel);
	}
}

class A02 {
	public int find(String[] arr, String n) {
		int i = 0;
		while(arr[i] != n) {
			i++;
		}
		if (i == arr.length) return -1;
		else return i;
	}
}
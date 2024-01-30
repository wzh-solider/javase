public class VarParameter01 {
	public static void main(String[] args) {
		Method m = new Method();
		int sum = m.sum(1, 2, 3);
		System.out.println(sum);
		int[] arr = {3, 4, 5};
		Method01 m1 = new Method01();
		int sum1 = m1.sum(arr);
		System.out.println(sum1);
	}
}

class Method {
	public int sum(int... nums) {
		int sum = 0;
		for(int i = 0; i < nums.length; i++)
			sum += nums[i];
		return sum;
	}
}

class Method01 {
	public int sum(int... nums) {
		int sum = 0;
		for (int i = 0; i < nums.length; i++) 
			sum += nums[i];
		return sum;
	}
}
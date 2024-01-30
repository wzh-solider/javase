public class RecursionExerise01 {
	public static void main(String[] args) {
		T1.recursion(1, 1);
		System.out.println(T2.fibonacci(17));
		System.out.print(T3.Monkey(1));
	}
}

class T1 {
	public static int recursion(int f1, int f2) {
		if (f1 < 10000) {
		System.out.println(f1 + "\t" +  f2);
		f1 = f1 + f2;
		f2 = f1 + f2;
		recursion(f1, f2);
	}
		return 0;
	}
}

class T2 {
	public static int fibonacci(int n) {
		if (n >= 1) {
		if (n == 1 || n == 2) {
			return 1;
		} else
			return  fibonacci(n - 1) + fibonacci(n - 2);
		} else {
			System.out.println("输入>=1的整数");
			return -1;
		}
	}
}

class T3 {
	public static int Monkey(int day) {
		if (day == 10) {
			return 1;
		} else if(day >= 1 && day <= 9){
			return (Monkey(day + 1) + 1) * 2;
		} else return -1;
	}
}
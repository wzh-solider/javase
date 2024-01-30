public class Homework04 {
	public static void main(String[] args) {
		A03 a = new A03();
		int[] arr = {1, 2, 3, 4, 5};
		int[] newArr = a.copyArr(arr);
		for (int i = 0; i < newArr.length; i++)
			System.out.print(newArr[i] + " ");
	}
}

class A03 {
	public int[] copyArr(int[] arr) {
		int[] newArr = new int[arr.length];
		for(int i = 0; i < arr.length; i++)
			newArr[i] = arr[i];
		return newArr;
	}
}
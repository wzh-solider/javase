import java.util.*;

public class BitOperation {
	public static void main(String[] args) {
		int a = 1 >> 2;
		int b = -1 >> 2;
		int c = 1 << 2;
		int d = -1 << 2;
		int e = 3 >>> 2;
		int f = 2 | 3;
		System.out.println("a = " + a);
		System.out.println("b = " + b);
		System.out.println("c = " + c);
		System.out.println("d = " + d);
		System.out.println("e = " + e);
		System.out.println("f = " + f);
		System.out.println("bµÄÔ­Âë = " + Integer.toString(-1, 2));
	}
}
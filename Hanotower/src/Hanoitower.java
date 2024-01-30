
public class Hanoitower {
    public static void main(String[] args) {
        A01 a01 = new A01();
        a01.move(3, "A", "B", "C");
    }
}

class A01 {
    public void move(int n, String A, String B, String C) {
        if (n == 1) {
            System.out.println(A + "->" + C);
        } else {
            move(n - 1, A, C, B);
            System.out.println(A + "->" + C);
            move(n - 1, B, A, C);
        }
    }
}

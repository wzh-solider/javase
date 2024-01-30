import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        Scanner myScanner = new Scanner(System.in);
        int[] arr = {1, 2, 3, 4, 5};
        while (true) {
            int[] arrNew = new int[arr.length - 1];
            for (int i = 0; i < arrNew.length; i++) {
                arrNew[i] = arr[i];
            }
            System.out.println("====缩减后的数组====");
            for (int i = 0; i < arrNew.length; i++) {
                System.out.print(arrNew[i]);
            }
            System.out.print("\n是否还要继续缩减(y / n):");
            char key = myScanner.next().charAt(0);
            if (key == 'n') break;
            if (arrNew.length == 1) {
                System.out.println("数组不能再缩减！！！");
                break;
            }
            arr = arrNew;
        }
        System.out.println("====最终的数组为====");
        for (int i = 0; i < arr.length - 1; i++) {
            System.out.print(arr[i]);
        }
    }
}

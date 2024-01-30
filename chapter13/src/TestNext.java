import java.util.Scanner;

public class TestNext {
    public static void main(String[] args) {
        Scanner myScanner = new Scanner(System.in);
        int[] arr = {1, 2, 3, 4, 5};
        int count = 0, len = arr.length;
        while (arr.length != 1) {
            count++;
            int[] arrNew = new int[arr.length - 1];
            for (int i = 0; i < arrNew.length; i++) {
                arrNew[i] = arr[i];
            }
            arr = arrNew;
            System.out.println("====第" + count + "次缩减后的数组为====");
            for (int i = 0; i < arr.length; i++) {
                System.out.print(arr[i]);
            }
            System.out.print("\n是否还要继续缩减(y / n):");
            char key = myScanner.next().charAt(0);
            while (key != 'n' && key != 'y') {
                System.out.print("您的输入有误，请重新输入(y / n):");
                key = myScanner.next().charAt(0);
            }
            if (key == 'n') break;
        }
        if (count == len - 1) {
            System.out.println("数组不可再缩减！！！");
        }
        System.out.println("====最终的数组为====");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
        }
    }
}

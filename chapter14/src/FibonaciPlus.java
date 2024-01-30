import java.util.Scanner;

public class FibonaciPlus {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        int bit = num % 10;
        int ten = (num / 10) % 10;
        int hundred = num / 100;
        if (num == Math.pow(bit, 3) + Math.pow(ten, 3) + Math.pow(hundred, 3)) {
            System.out.println("该数是一个水仙花数");
        } else {
            System.out.println("该数不是一个水仙花数");
        }
    }
}

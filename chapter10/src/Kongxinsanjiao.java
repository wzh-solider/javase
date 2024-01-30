public class Kongxinsanjiao {
    public static void main(String[] args) {
        //1-100 以内的数求和。求出 当和 第一次大于20 的当前数 (for + break)
        int sum = 0;
        int i;
        for (i = 1; i <= 100; i++) {
            sum += i;
            if (sum > 20) break;
        }
        System.out.println("当前数为：" + i);
    }
}

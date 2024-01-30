import java.util.LinkedHashSet;
import java.util.Set;

@SuppressWarnings({"all"})
public class Fibonaci {
    public static void main(String[] args) {
        int count = 0;
        for (int i = 1; i <= 100; i++) {
            if (i % 5 != 0) {
                count++;
                System.out.print("i=" + i + " ");
                if (count % 5 == 0) {
                    count = 0;
                    System.out.println();
                }
            }
        }
    }
}

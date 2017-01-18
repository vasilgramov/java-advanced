import java.util.Scanner;

public class p08_hitTheTarget {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int target = in.nextInt();

        for (int i = 1; i <= 20; i++) {
            for (int j = 1; j <= 20; j++) {
                if (i + j == target) {
                    System.out.printf("%d + %d = %d\n", i, j, target);
                    break;
                }
                else if (i - j == target) {
                    System.out.printf("%d - %d = %d\n", i, j, target);
                    break;
                }
            }
        }
    }
}

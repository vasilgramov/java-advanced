import java.util.ArrayList;
import java.util.Scanner;

public class p14_theStockSpanProblem {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = Integer.parseInt(in.nextLine());
        ArrayList<Integer> dailyPrices = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            dailyPrices.add(Integer.parseInt(in.nextLine()));

            int count = 0;
            for (int j = i; j >= 0; j--) {
                // TODO:
            }
        }
    }
}

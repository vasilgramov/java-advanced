import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.function.BiPredicate;

public class p11_listOfPredicates {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(in.readLine());
        String[] nums = in.readLine().split("\\s+");

        BiPredicate<Integer, String[]> isDivisible = (num, c) -> {
            for (String s : c) {
                int current = Integer.parseInt(s);
                if (num % current != 0)
                    return false;
            }

            return true;
        };

        for (int i = 1; i <= n; i++) {
            if (isDivisible.test(i, nums)) {
                System.out.print(i + " ");
            }
        }
    }
}

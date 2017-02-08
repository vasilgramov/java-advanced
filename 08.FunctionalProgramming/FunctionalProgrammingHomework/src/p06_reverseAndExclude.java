import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.function.Consumer;

public class p06_reverseAndExclude {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        String[] nums = in.readLine().split("\\s+");
        int n = Integer.parseInt(in.readLine());

        Consumer<String[]> reverserAndExclude = numbers -> {
            for (int i = numbers.length - 1; i >= 0; i--) {
                int currentNum = Integer.parseInt(numbers[i]);
                if (currentNum % n != 0)
                    System.out.print(currentNum + " ");
            }
        };

        reverserAndExclude.accept(nums);
    }
}

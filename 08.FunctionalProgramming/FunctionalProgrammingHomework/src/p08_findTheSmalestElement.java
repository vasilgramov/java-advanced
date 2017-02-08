import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.function.Function;

public class p08_findTheSmalestElement {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        String[] numbersAsStr = in.readLine().split("\\s+");
        int[] numbers = new int[numbersAsStr.length];

        int index = 0;
        for (String str : numbersAsStr) {
            numbers[index++] = Integer.parseInt(str);
        }

        Function<int[], Integer> findSmallestNumberIndex = n -> {
            int smallest = n[0];
            int i = 0;
            for (int j = 1; j < n.length; j++) {
                if (n[j] <= smallest) {
                    smallest = n[j];
                    i = j;
                }
            }

            return i;
        };

        System.out.println(findSmallestNumberIndex.apply(numbers));
    }
}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.function.Consumer;
import java.util.function.Function;

public class p09_customComparator {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        String[] numbersAsString = in.readLine().split("\\s+");
        int[] nums = new int[numbersAsString.length];

        for (int i = 0; i < numbersAsString.length; i++) {
            nums[i] = Integer.parseInt(numbersAsString[i]);
        }

        Function<int[], int[]> customSort = n -> {
            int[] customSorted = new int[n.length];

            ArrayList<Integer> evenNums = new ArrayList<>();
            ArrayList<Integer> oddNums = new ArrayList<>();

            for (int i : n) {
                if (i % 2 == 0)
                    evenNums.add(i);
                else
                    oddNums.add(i);
            }

            Collections.sort(evenNums);
            Collections.sort(oddNums);

            int i = 0;
            for (Integer evenNum : evenNums) {
                customSorted[i++] = evenNum;
            }

            for (Integer oddNum : oddNums) {
                customSorted[i++] = oddNum;
            }

            return customSorted;
        };

        int[] sorted = customSort.apply(nums);
        for (int num : sorted) {
            System.out.print(num + " ");
        }
    }
}

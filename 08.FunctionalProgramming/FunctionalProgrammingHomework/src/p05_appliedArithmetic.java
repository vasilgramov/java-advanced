import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.function.Consumer;
import java.util.function.UnaryOperator;

public class p05_appliedArithmetic {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        String[] numbersAsString = in.readLine().split("\\s+");
        int[] nums = new int[numbersAsString.length];
        for (int i = 0; i < numbersAsString.length; i++) {
            nums[i] = Integer.parseInt(numbersAsString[i]);
        }

        UnaryOperator<int[]> addFunc = n -> {
            for (int i = 0; i < n.length; i++) {
                n[i]++;
            }

            return n;
        };

        UnaryOperator<int[]> subtractFunc = n -> {
            for (int i = 0; i < n.length; i++) {
                n[i]--;
            }

            return n;
        };

        UnaryOperator<int[]> multiplyFunc = n -> {
            for (int i = 0; i < n.length; i++) {
                n[i] *= 2;
            }

            return n;
        };

        Consumer<int[]> printFunc = n -> {
            for (int i = 0; i < n.length; i++) {
                System.out.print(n[i] + " ");
            }

            System.out.println();
        };

        String command = in.readLine().toLowerCase();
        while (!"end".equals(command)) {
            switch (command) {
                case "add":
                    addFunc.apply(nums);
                    break;
                case "subtract":
                    subtractFunc.apply(nums);
                    break;
                case "multiply" :
                    multiplyFunc.apply(nums);
                    break;
                case "print":
                    printFunc.accept(nums);
                    break;
            }

            command = in.readLine().toLowerCase();
        }
    }
}

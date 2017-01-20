import java.util.ArrayDeque;
import java.util.Scanner;

public class p02_simpleCalculator {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        String[] input = in.nextLine().split("\\s+");


        ArrayDeque<String> expression = new ArrayDeque<>();
        for (int i = 0; i < input.length; i++) {
            expression.add(input[i]);
        }

        int result = Integer.parseInt(expression.pop());
        while (expression.size() > 0) {
            String operand = expression.pop();
            int second = Integer.parseInt(expression.pop());

            if (operand.equals("+")) {
                result = result + second;
            } else {
                result = result - second;
            }
        }

        System.out.println(result);
    }
}

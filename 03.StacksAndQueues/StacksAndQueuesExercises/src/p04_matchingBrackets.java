import java.util.ArrayDeque;
import java.util.Scanner;

public class p04_matchingBrackets {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        String expression = in.nextLine();
        ArrayDeque<Integer> startingBracketsIndexes = new ArrayDeque<>();

        for (int i = 0; i < expression.length(); i++) {
            if (expression.charAt(i) == '(') {
                startingBracketsIndexes.add(i);
                continue;
            }

            if (expression.charAt(i) == ')') {
                System.out.println(expression.substring(startingBracketsIndexes.pollLast(), i + 1));
            }
        }
    }
}

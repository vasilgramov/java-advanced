import java.util.ArrayDeque;
import java.util.Scanner;

public class p01_reverseNumberWithStack {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        ArrayDeque<String> stack = new ArrayDeque<>();
        String[] input = in.nextLine().split("\\s+");
        for (int i = 0; i < input.length; i++) {
            stack.addFirst(input[i]);
        }

        for (String s : stack) {
            System.out.print(s + " ");
        }
        System.out.println();
    }
}

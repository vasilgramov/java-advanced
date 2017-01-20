import java.util.ArrayDeque;
import java.util.Scanner;

public class p07_palindromeChecker {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        char[] input = in.nextLine().toCharArray();
        ArrayDeque<Character> holder = new ArrayDeque<>();

        for (char symbol : input) {
            holder.add(symbol);
        }

        while (holder.size() > 1) {
            char startChar = holder.pollFirst();
            char endChar = holder.pollLast();

            if (startChar != endChar) {
                System.out.println("false");
                return;
            }
        }

        System.out.println("true");
    }
}

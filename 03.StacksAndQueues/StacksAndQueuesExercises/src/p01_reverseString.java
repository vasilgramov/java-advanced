import java.util.ArrayDeque;
import java.util.Scanner;

public class p01_reverseString {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        String input = in.nextLine();
        ArrayDeque<Character> reversedString = new ArrayDeque<>();
        for (int i = 0; i < input.length(); i++) {
            reversedString.push(input.charAt(i));
        }

        for (Character symbol : reversedString) {
            System.out.print(symbol);
        }

        System.out.println();
    }
}

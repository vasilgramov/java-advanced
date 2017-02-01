import java.util.Scanner;

public class p12_charMultiplier {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        String[] input = in.nextLine().split("\\s+");
        String first = input[0];
        String second = input[1];

        int result = 0;
        int iterations = first.length() > second.length() ? second.length() : first.length();
        for (int i = 0; i < iterations; i++) {
            result += first.charAt(i) * second.charAt(i);
        }

        for (int i = iterations; i < first.length(); i++) {
            result += first.charAt(i);
        }

        for (int i = iterations; i < second.length(); i++) {
            result += second.charAt(i);
        }

        System.out.println(result);
    }
}

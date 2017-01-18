import java.util.Scanner;

public class p09_characterMultiplier {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        String firstStr = in.next();
        String secondStr = in.next();

        long result = 0L;
        int iterations = firstStr.length() < secondStr.length() ? firstStr.length() : secondStr.length();
        for (int i = 0; i < iterations; i++) {
            result += firstStr.charAt(i) * secondStr.charAt(i);
        }

        if (firstStr.length() > secondStr.length()) {
            for (int i = iterations; i < firstStr.length(); i++) {
                result += firstStr.charAt(i);
            }
        } else if (secondStr.length() > firstStr.length()) {
            for (int i = iterations; i < secondStr.length(); i++) {
                result += secondStr.charAt(i);
            }
        }

        System.out.println(result);
    }
}

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Scanner;

public class p03_formattingNumbers {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int a = in.nextInt();
        double b = in.nextDouble();
        double c = in.nextDouble();

        String hexA = Integer.toHexString(a).toUpperCase();
        String binA = Integer.toBinaryString(a);
        binA = paddedBinA(binA);
        String formatB = String.format("%.2f", b);
        String formatC = String.format("%.3f", c);

        System.out.println("|" + padRight(hexA, 10) + "|" + binA + "|" + padLeft(formatB, 10) + "|" + padRight(formatC, 10) + "|");
    }

    private static String paddedBinA(String binA) {
        int length = binA.length();

        return newString("0", 10 - length) + binA;
    }

    private static String newString(String str, int n) {
        StringBuilder builder = new StringBuilder();

        for (int i = 0; i < n; i++) {
            builder.append(str);
        }

        return builder.toString();
    }

    public static String padRight(String s, int n) {
        return String.format("%1$-" + n + "s", s);
    }

    public static String padLeft(String s, int n) {
        return String.format("%1$" + n + "s", s);
    }
}

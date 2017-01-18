import java.text.DecimalFormat;
import java.util.Scanner;

public class p04_calculateExpression {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        double a = in.nextDouble();
        double b = in.nextDouble();
        double c = in.nextDouble();

        double f1 = Math.pow(((Math.pow(a, 2) + Math.pow(b, 2)) / ((Math.pow(a, 2) - Math.pow(b, 2)))), ((a + b + c) / Math.sqrt(c)));
        double f2 = Math.pow(Math.pow(a, 2) + Math.pow(b, 2) - Math.pow(c, 3), (a - b));

        double avgABC = (a + b + c) / 3;
        double avgF1F2 = (f1 + f2) / 2;

        System.out.printf("F1 result: %.2f; F2 result: %.2f; Diff: %.2f", f1, f2, Math.abs(avgABC - avgF1F2));
    }
}

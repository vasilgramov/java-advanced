import java.util.Scanner;

public class p09_calculateTriangleArea {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        double base = in.nextDouble();
        double height = in.nextDouble();

        printTriangleArea(base, height);
    }

    private static void printTriangleArea(double base, double height) {
        System.out.printf("Area = %.2f", base * height / 2);
    }
}

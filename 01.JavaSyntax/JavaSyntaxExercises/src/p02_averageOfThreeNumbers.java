import java.util.Scanner;

public class p02_averageOfThreeNumbers {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        double fNum = in.nextDouble();
        double sNum = in.nextDouble();
        double tNum = in.nextDouble();

        System.out.printf("%.2f", (fNum + sNum + tNum) / 3);
    }
}

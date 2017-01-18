import java.util.Scanner;

public class p01_rectangleArea {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        double width = in.nextDouble();
        double height = in.nextDouble();

        System.out.printf("%.2f", width * height);
    }
}

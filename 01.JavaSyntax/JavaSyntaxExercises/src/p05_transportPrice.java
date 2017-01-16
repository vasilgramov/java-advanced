import java.util.Scanner;

public class p05_transportPrice {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        double kilos = in.nextDouble();
        String time = in.next();

        if (kilos >= 100) {
            System.out.printf("%.2f", kilos * 0.06);
        } else if (kilos >= 20) {
            System.out.printf("%.2f", kilos * 0.09);
        } else {
            if (time.equals("day")) {
                System.out.printf("%.2f", kilos * 0.79 + .70);
            } else {
                System.out.printf("%.2f", kilos * 0.9 + .70);
            }
        }
    }
}

import java.math.BigDecimal;
import java.util.Scanner;

public class p03_euroTrip {
    static final double PRICE_PER_KILO = 1.20;
    static final BigDecimal PRICE_IN_MARKS = new BigDecimal("4210500000000");

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        double quantityInKG = Double.parseDouble(in.nextLine());
        BigDecimal priceInLevs = new BigDecimal(PRICE_PER_KILO * quantityInKG);

        BigDecimal marks = PRICE_IN_MARKS.multiply(priceInLevs);
        System.out.printf("%.2f marks", marks);
    }
}

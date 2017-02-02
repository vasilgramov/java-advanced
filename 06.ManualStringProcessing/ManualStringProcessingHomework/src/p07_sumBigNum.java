import java.math.BigInteger;
import java.util.Scanner;

public class p07_sumBigNum {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        String first = in.nextLine();
        String second = in.nextLine();

        BigInteger result = new BigInteger(first).add(new BigInteger(second));
        System.out.println(result);
    }
}

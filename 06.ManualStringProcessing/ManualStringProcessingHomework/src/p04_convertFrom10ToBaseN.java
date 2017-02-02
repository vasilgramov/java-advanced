import java.math.BigInteger;
import java.util.Scanner;

public class p04_convertFrom10ToBaseN {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        String[] input = in.nextLine().split("\\s+");
        BigInteger baseN = new BigInteger(input[0]);
        BigInteger num = new BigInteger(input[1]);

        StringBuilder result = new StringBuilder();
        while (num.compareTo(new BigInteger("0")) != 0) {
            result.append(num.remainder(baseN));
            num = num.divide(baseN);
        }

        System.out.println(result.reverse());
    }
}

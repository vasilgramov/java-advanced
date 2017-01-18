import java.math.BigInteger;
import java.util.Scanner;

public class p06_convertFromBase7ToDecimal {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        String numberToConvert = in.nextLine();

        long result = 0L;
        int pow = 0;
        for (int i = numberToConvert.length() - 1; i >= 0; i--)
        {
            int currentNumber = Integer.parseInt(Character.toString(numberToConvert.charAt(i)));
            result += currentNumber * Math.pow(7, pow);
            pow++;
        }

        System.out.println(result);
    }
}
